package com.flavio.microservice.tarefa.model;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	private LocalDateTime dataKimite;
	
	private Boolean concluida = false;
	
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade = Prioridade.MEDIA;
	
	private Long userId;
	
//    @ManyToOne
//    @JoinColumn(name = "userId")
//	private Usuario userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Tarefa() {
		
	}

	public Tarefa(Long id, String titulo, String descricao2, LocalDateTime dataKimit, Boolean concluida,
			Prioridade prioridade,Long userId) {
		
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataKimite = dataKimite;
		this.concluida = concluida;
		this.prioridade = prioridade;
		this.userId = userId;
		
		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDateTime getDataKimite() {
		return dataKimite;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataKimite(LocalDateTime dataKimite) {
		this.dataKimite = dataKimite;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

		
	
	
	

}
