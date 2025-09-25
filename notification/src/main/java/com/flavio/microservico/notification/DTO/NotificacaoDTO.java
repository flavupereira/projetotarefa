package com.flavio.microservico.notification.DTO;

import javax.management.Notification;

import com.flavio.microservico.notification.model.Notificacao;

public class NotificacaoDTO {

	private Long userId;
	private String mensagem;
	

	public NotificacaoDTO() {
	
	}

	public NotificacaoDTO(Notificacao notificacao) {
		notificacao.setUserId(this.userId);
		notificacao.setMensagem(this.mensagem);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
