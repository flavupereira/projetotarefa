package com.flavio.microservice.tarefa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flavio.microservice.tarefa.DTO.InforUsuarioDTO;

@FeignClient(name = "usuario-service", url = "${usuario.service.url}")
public interface UsuarioCliente {
	
    @GetMapping("/usuarios/info/{id}")
    InforUsuarioDTO  getUserId(@PathVariable("id") Long id);


}
