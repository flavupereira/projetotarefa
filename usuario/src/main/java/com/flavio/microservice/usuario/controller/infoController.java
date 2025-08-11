package com.flavio.microservice.usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flavio.microservice.usuario.service.InfoServiceUser;

@Controller("/info")
public class infoController {
	
	private InfoServiceUser infoServiceUser;
	
	@RequestMapping("/{id}")
	public void getInfoUser(Long id) {
		infoServiceUser.getUserId(id);
	}

}
