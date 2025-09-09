package com.flavio.microservice.tarefa.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.flavio.microservice.tarefa.model.Prioridade;
import com.flavio.microservice.tarefa.model.Tarefa;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class TarefaForm {

	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime datalimite;
	private Boolean concluida ;
	private Prioridade prioridade;
    private Long userId;
	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public LocalDateTime getDataKimite() {
		return datalimite;
	}

	public void setDataKimite(LocalDateTime dataKimite) {
		this.datalimite = dataKimite;
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

	public Tarefa converte() {
		
		return new Tarefa(id,titulo,descricao,datalimite,concluida,prioridade,userId);
	}

	

	public Tarefa atualizar(Tarefa tarefa) {
		if (this.titulo != null) {
	        tarefa.setTitulo(this.titulo);
	    }
	    if (this.descricao != null) {
	        tarefa.setDescricao(this.descricao);
	    }
	    if (this.prioridade != null) {
	        tarefa.setPrioridade(this.prioridade);
	    }
	    return tarefa;
	}

}
