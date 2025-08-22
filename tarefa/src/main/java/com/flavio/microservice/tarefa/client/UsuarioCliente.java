package com.flavio.microservice.tarefa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "${usuario.service.url}")
public interface UsuarioCliente {
	
    @GetMapping("/usuarios/info/{id}")
    Object getUserId(@PathVariable("id") Long id); // Use Object ou o DTO correto


}
