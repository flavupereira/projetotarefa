package com.flavio.microservice.tarefa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.flavio.microservice.tarefa.DTO.TarefaDTO;
import com.flavio.microservice.tarefa.DTO.TarefaForm;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping
	public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaForm tareFarom, UriComponentsBuilder uriBuilder) {
//		Tarefa tarefa = tarefarom.converte();

		Tarefa tarefa = tarefaService.criaTarefa(tareFarom);

		URI uri = uriBuilder.path("/tarefa/{id}").buildAndExpand(tarefa.getId()).toUri();

		return ResponseEntity.created(uri).body(new TarefaDTO(tarefa));

	}

	@GetMapping
	public List<TarefaController> listaTarefa() {

		tarefaService.buscaTarefas();
		return null;

	}

	@PutMapping("/{id}")
	public ResponseEntity<TarefaDTO> alterar(@PathVariable Long id, @RequestBody @Validated TarefaForm form) {
		Tarefa tarefa = tarefaService.atualizarTarefa(id, form);

		return ResponseEntity.ok(new TarefaDTO(tarefa));

	}

	@GetMapping("/{id}")
	public ResponseEntity<TarefaDTO> detalhar(@PathVariable Long id) {
		try {
			Tarefa tarefa = tarefaService.buscaPorId(id);
			return ResponseEntity.ok(new TarefaDTO(tarefa));
		}catch (RuntimeException e){
			return  ResponseEntity.notFound().build();
		}
		
		
		

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefa> deletarTarefa(@PathVariable Long id) {
		Optional<Tarefa> tarefaDeletada = tarefaService.deletar(id);

		return tarefaDeletada.map(tarefa -> ResponseEntity.ok(tarefa)).orElse(ResponseEntity.notFound().build());
	}

}
