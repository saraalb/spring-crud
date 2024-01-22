package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//modelar os atributos e a tabela ponstagens do banco de dados
@Entity
@Table(name="tb_postagens")
public class Postagem {
	
	@Id //tornar esse atributo uma pk
	@GeneratedValue(strategy=GenerationType.IDENTITY) //adicionar o id como auto increment
	private Long id;
	
	//essa anotacao valida o atributo tendo um valor maximo e minimo de caracteres
	@Size(min=5, max=100, message = "o título deve ter no mínimo 5 caracteres e no máximo 100.")
	@NotBlank(message = "Atributo título é obrigatório") //notblank trata atributos nulos, vazios e atributos nao passados ou referenciados na hora do cadastro
	private String titulo;
	
	@Size(min=10, max=1000, message = "o texto deve ter no mínimo 10 caracteres e no máximo 1000.")
	@NotBlank(message = "Atributo texto é obrigatório")
	private String texto;
	
	@UpdateTimestamp //pega a data do sistema ao cadastrar um registro
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}







