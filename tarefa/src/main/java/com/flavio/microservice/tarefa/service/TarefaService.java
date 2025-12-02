package com.flavio.microservice.tarefa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.flavio.microservice.tarefa.DTO.TarefaForm;
import com.flavio.microservice.tarefa.DTO.InforUsuarioDTO;
import com.flavio.microservice.tarefa.DTO.TarefaDTO;
import com.flavio.microservice.tarefa.client.UsuarioCliente;
import com.flavio.microservice.tarefa.componente.TaskEventPublisher;
import com.flavio.microservice.tarefa.model.Tarefa;
import com.flavio.microservice.tarefa.repository.TarefaRepository;

import jakarta.transaction.Transactional;

@Service
public class TarefaService {

	private final UsuarioCliente usuarioClient;

	private final TarefaRepository tarefaRepository;
	
	private final TaskEventPublisher taskEventPublisher; 

	
	public TarefaService(UsuarioCliente usuarioClient, TarefaRepository tarefaRepository,
			TaskEventPublisher taskEventPublisher) {
	
		this.usuarioClient = usuarioClient;
		this.tarefaRepository = tarefaRepository;
		this.taskEventPublisher = taskEventPublisher;
	}





	public Tarefa criaTarefa(TarefaForm tareFarom) {

		System.out.println("UserId recebido: " + tareFarom.getUserId());
		InforUsuarioDTO info = usuarioClient.getUserId(tareFarom.getUserId());

		if (info == null) {
			throw new RuntimeException("id não encontrado");
		}

		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo(tareFarom.getTitulo());
		tarefa.setDescricao(tareFarom.getDescricao());
		tarefa.setDataKimite(tareFarom.getDataKimite());
		tarefa.setPrioridade(tareFarom.getPrioridade());
		tarefa.setUserId(tareFarom.getUserId());

		Tarefa saved  = tarefaRepository.save(tarefa);
		
		 taskEventPublisher.publishTaskCreated(
				 saved.getUserId(), 
				 saved.getTitulo());
		
		return saved;

	}

	
	public List<TarefaDTO> buscaTarefas() {

		List<Tarefa> tarefas = tarefaRepository.findAll();

		return tarefas.stream().map(TarefaDTO::new).collect(Collectors.toList());

	}

	public Optional<Tarefa> deletar(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isPresent()) {
			tarefaRepository.deleteById(id);
		}
		return tarefa;

	}

	@Transactional
	public Tarefa atualizarTarefa(Long id, TarefaForm form) {

		Tarefa tarefaId = tarefaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		form.atualizar(tarefaId);
		return tarefaRepository.save(tarefaId);

	}

	public Tarefa buscaPorId(Long id) {
		return  tarefaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		
	}

}
