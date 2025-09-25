package com.flavio.microservico.notification.service;

import java.time.LocalDateTime;

import com.flavio.microservico.notification.DTO.NotificacaoDTO;
import com.flavio.microservico.notification.model.Notificacao;
import com.flavio.microservico.notification.repository.NotificacaoRepository;

public class NotificationService {
	
	private final NotificacaoRepository repository;

	public NotificationService(NotificacaoRepository repository) {
		
		this.repository = repository;
	}
	
	public void saveNotification(NotificacaoDTO mensagem  ) {
		
		Notificacao notificaticao = new Notificacao();
		
		notificaticao.setUserId(mensagem.getUserId());
		notificaticao.setMensagem(mensagem.getMensagem());
		notificaticao.setDataEnvio(LocalDateTime.now());
		repository.save(notificaticao);
		
	}
    
}
