package com.flavio.microservice.tarefa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flavio.microservice.tarefa.DTO.TarefaForm;
import com.flavio.microservice.tarefa.DTO.inforUsuarioDTO;
import com.flavio.microservice.tarefa.client.Usuarioclient;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	Usuarioclient usuarioClient;
	
//	@Autowired
//	private RestTemplate cliente;

	public Tarefa criaTarefa(TarefaForm tarefarom) {
		
		inforUsuarioDTO info  = usuarioClient.getUserId(tarefarom.getId());
		
		//RestTemplate cliente = new RestTemplate();
//		ResponseEntity<inforUsuarioDTO> exchange = cliente.exchange("https://usuario/info/" +tarefarom.getUserId(),
//		   HttpMethod.GET , null , inforUsuarioDTO.class);
//		
//		var tarefa = tarefarom.converte();
//		
		return null; 
		// TODO Auto-generated method stub
		
	}

}
