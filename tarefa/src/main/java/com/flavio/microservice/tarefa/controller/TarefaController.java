package com.flavio.microservice.tarefa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.flavio.microservice.tarefa.DTO.TarefaDTO;
import com.flavio.microservice.tarefa.DTO.TarefaForm;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.repository.TarefaRepository;
import com.flavio.microservice.tarefa.service.TarefaService;


@RestController
@RequestMapping("tarefa")
public class TarefaController {
	
	
	
	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping
	public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaForm tarefarom ,UriComponentsBuilder uriBuilder) {
//		Tarefa tarefa = tarefarom.converte();
		
		Tarefa tarefa = tarefaService.criaTarefa(tarefarom);
		
	   URI uri = uriBuilder.path("/tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();
	   
       return ResponseEntity.created(uri).body(new TarefaDTO(tarefa));
			
		
	}
	
	
	
	

}
