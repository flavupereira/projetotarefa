package com.flavio.microservice.usuario.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.flavio.microservice.DTO.AtualizacaoUsuarioForm;
import com.flavio.microservice.DTO.UsuarioDTO;
import com.flavio.microservice.DTO.UsuarioForm;
import com.flavio.microservice.usuario.UsuarioApplication;
import com.flavio.microservice.usuario.model.Usuario;
import com.flavio.microservice.usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


	@Autowired
	UsuarioRepository usuarioRepository;

	

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeUsuarios" , allEntries = true)
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converte();

		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));

	}

	@GetMapping
	@Cacheable(value = "listaDeUsuarios")
	public Page<UsuarioDTO> listaUsuario(@RequestParam(required = false) String nomeUsuario,
			@PageableDefault(sort ="id" , direction = Direction.DESC , page = 0 , size = 5) 
	        Pageable paginacao ) {
		

		if (nomeUsuario == null) {
			Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
			return UsuarioDTO.converter(usuarios);
		} else {
			Page<Usuario> usuarios = usuarioRepository.findByNome(nomeUsuario , paginacao);
			return UsuarioDTO.converter(usuarios);

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent())	{
			return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
		}

         return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeUsuarios" , allEntries = true)
	public  ResponseEntity<UsuarioDTO> autializar(@PathVariable Long id ,
			@RequestBody  @Valid AtualizacaoUsuarioForm form){
		
		Optional<Usuario> optipnal = usuarioRepository.findById(id);
		if(optipnal.isPresent())	{
			Usuario usuario = form.atualizar(id , usuarioRepository);
			return ResponseEntity.ok(new UsuarioDTO(usuario));
		}

		 return ResponseEntity.notFound().build();
		
	}
	
    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeUsuarios" , allEntries = true)
	public ResponseEntity<?> renover(@PathVariable Long id){
    	Optional<Usuario> optipnal = usuarioRepository.findById(id);
    	if(optipnal.isPresent())	{
    		usuarioRepository.deleteById(id);
		}
		
		return ResponseEntity.ok().build();
		
	}
   
	
}
