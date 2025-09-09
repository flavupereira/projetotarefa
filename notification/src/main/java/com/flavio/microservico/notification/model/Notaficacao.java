package com.flavio.microservico.notification.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notaficacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	private String mensagem;
	private LocalDateTime dataEnvio = LocalDateTime.now();
	private Boolean enviada = false;
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
	public Boolean getEnviada() {
		return enviada;
	}
	public void setEnviada(Boolean enviada) {
		this.enviada = enviada;
	}
	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}
	
	
	
	

}
