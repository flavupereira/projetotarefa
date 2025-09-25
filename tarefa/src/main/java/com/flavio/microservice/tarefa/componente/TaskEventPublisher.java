package com.flavio.microservice.tarefa.componente;

import org.hibernate.annotations.Comment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.flavio.microservice.tarefa.DTO.NotificationMessageDto;

@Component
public class TaskEventPublisher {
	
	private final RabbitTemplate rabbitTemplate;

	public TaskEventPublisher(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	public void publishTaskCreated(Long userId, String titulo) {
		
		NotificationMessageDto msg = new NotificationMessageDto(
				userId, " Nova tarefa criada: " + titulo); 
		rabbitTemplate.convertAndSend("task-exchange", "task.notificacao",msg);
		      
	}

}
