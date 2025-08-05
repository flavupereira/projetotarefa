package com.flavio.microservice.tarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flavio.microservice.tarefa.DTO.UsuarioForm;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.service.TarefaService;

@RestController
@RequestMapping("tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping
	public void criarTarefa(@RequestBody UsuarioForm tarefaDTO) {
		tarefaService.converterTarefa(tarefaDTO);
			
		
	}
	

}
