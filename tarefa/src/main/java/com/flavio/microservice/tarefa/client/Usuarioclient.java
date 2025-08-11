package com.flavio.microservice.tarefa.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flavio.microservice.tarefa.DTO.inforUsuarioDTO;


@FeignClient("usuario")
public interface Usuarioclient {

	@RequestMapping("/info/{id}")
	inforUsuarioDTO getUserId(@PathVariable long id);
}
