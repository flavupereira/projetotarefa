package com.flavio.microservice.tarefa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flavio.microservice.tarefa.DTO.UsuarioForm;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;

	public void converterTarefa(UsuarioForm tarefaDTO) {
		Tarefa tarefa = tarefaDTO.criaTarefaDTO(new Tarefa());
		tarefaRepository.save(tarefa);
		
	}

	

}
