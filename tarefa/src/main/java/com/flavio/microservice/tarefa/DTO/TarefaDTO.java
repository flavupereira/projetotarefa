package com.flavio.microservice.tarefa.DTO;

import java.time.LocalDateTime;

import com.flavio.microservice.tarefa.model.Prioridade;
import com.flavio.microservice.tarefa.model.Tarefa;



public class TarefaDTO {
	
	
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDateTime dataCriacao; 
	
	private LocalDateTime dataKimite;
	
	private Boolean concluida = false;
	
	
	private Prioridade prioridade ;
	
	
	public TarefaDTO(Tarefa tarefa) {
		
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.dataCriacao = tarefa.getDataCriacao(); 
		this.dataKimite = tarefa.getDataKimite();
		this.concluida = tarefa.getConcluida();
		this.prioridade = tarefa.getPrioridade();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public LocalDateTime getDataKimite() {
		return dataKimite;
	}


	public void setDataKimite(LocalDateTime dataKimite) {
		this.dataKimite = dataKimite;
	}


	public Boolean getConcluida() {
		return concluida;
	}


	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}


	public Prioridade getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
	
	

}
