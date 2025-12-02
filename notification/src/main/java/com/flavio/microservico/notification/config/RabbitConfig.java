package com.flavio.microservico.notification.config;



import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue notificationQueue() {
    	 return new Queue("notifications_queue", true); // Corrigi também o nome da fila
    }
}
