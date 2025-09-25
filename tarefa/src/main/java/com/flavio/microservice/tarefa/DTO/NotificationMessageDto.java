package com.flavio.microservice.tarefa.DTO;

public class NotificationMessageDto {

	private Long userId;
	private String mensage;

	public NotificationMessageDto() {

	}

	public NotificationMessageDto(Long userId, String mensage) {
		this.userId = userId;
		this.mensage = mensage;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
	
	

}
