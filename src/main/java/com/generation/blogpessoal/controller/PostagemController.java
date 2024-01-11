package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins="*", allowedHeaders="*")//informa toda e qualquer origem pode acessar essa rota
public class PostagemController {
	
	//injeçao de dependencias
	@Autowired
	private PostagemRepository postagemRepository;
	
	//acessado pelo verbo get
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		//respostas no formato http
		
		return ResponseEntity.ok(postagemRepository.findAll());
		//findall = select * from nomedatabela
		//codigo de retorno -- corpo de retorno
	}
	
	@GetMapping("/exemplo")
	public ResponseEntity<String> exemplo(){
		String ola = "Olá mundo";
		//return ResponseEntity.badRequest().build();
		return ResponseEntity.noContent().build();
	}

}
