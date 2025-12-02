package com.flavio.microservice.tarefa.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;  // ← Esta é a IMPORTANTE
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

	// Exchange
	@Bean
	public TopicExchange taskExchange() {
		return new TopicExchange("task-exchange");
	}

	
	// Fila
    @Bean
    public Queue notificationQueue() {
        return new Queue("notificacoes-queue", true);
    }
	
 // Binding
    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange taskExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(taskExchange)
                .with("task.notificacao");
    }


}
