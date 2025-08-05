package com.flavio.microservice.tarefa.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.flavio.microservice.tarefa.model.Prioridade;
import com.flavio.microservice.tarefa.model.Tarefa;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UsuarioForm {

	static DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private Long id;

	private String titulo;

	private String descricao;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	private LocalDateTime dataKimite;

	private Boolean concluida = false;

	@Enumerated(EnumType.STRING)

	private Prioridade prioridade = Prioridade.MEDIA;

	

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public Tarefa criaTarefaDTO(Tarefa tarefa) {

		tarefa.setId(this.id);
		

		tarefa.setTitulo(this.titulo);

		tarefa.setDataCriacao(this.dataCriacao);

		tarefa.setDataKimite(this.dataKimite);

		tarefa.setConcluida(this.concluida);

		tarefa.setPrioridade(this.prioridade);
		return tarefa;
	}

}
