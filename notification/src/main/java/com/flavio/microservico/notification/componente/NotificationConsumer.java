package com.flavio.microservico.notification.componente;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flavio.microservico.notification.DTO.NotificacaoDTO;
import com.flavio.microservico.notification.service.NotificationService;

@Component
public class NotificationConsumer {

	@Autowired
	private NotificationService notificationService;

	@RabbitListener(queues = "notifications_queue")
	public void receive(NotificacaoDTO mensagem) {
		notificationService.saveNotification(mensagem);
	}

}
