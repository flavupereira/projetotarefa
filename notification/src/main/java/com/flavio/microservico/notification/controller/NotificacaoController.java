package com.flavio.microservico.notification.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flavio.microservico.notification.DTO.NotificacaoDTO;
import com.flavio.microservico.notification.model.Notaficacao;
import com.flavio.microservico.notification.repository.NotificacaoRepository;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

	@Autowired
	private NotificacaoRepository notificacaoRepository;
	private List<Notaficacao> tarefas;

	public List<NotificacaoDTO> listarNotificacao() {

		List<Notaficacao> notificacaoes = notificacaoRepository.findAll();

		return notificacaoes.stream().map(NotificacaoDTO::new).collect(Collectors.toList());

//		List<NotificacaoDTO> dtos = new ArrayList<>();
//		
//		for (Notaficacao notificacao  : notificacaoes) {
//			dtos.add(new NotificacaoDTO(notificacao ));
//		}
//		
//		return dtos;

	}

}
