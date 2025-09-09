package com.flavio.microservice.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flavio.microservice.usuario.DTO.UsuarioDTO;
import com.flavio.microservice.usuario.service.InfoServiceUser;

@RestController
@RequestMapping("/usuarios/info")
public class infoController {

	private final InfoServiceUser infoServiceUser;

	public infoController(InfoServiceUser infoServiceUser) {

		this.infoServiceUser = infoServiceUser;
	}

	@RequestMapping("/{id}")
	public UsuarioDTO getInfoUser(@PathVariable Long id) {
		return infoServiceUser.getUserId(id);

	}

}
