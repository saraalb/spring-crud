package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	//falar para segurança quais sao as informacoes que vamos usar para login
	
	private static final long serialVersionUID = 1L;
	//é um identificador da versão da classe
	
	private String userName; //usuario(email)
	private String password; //senha
	private List<GrantedAuthority> authorities;
	//essa classe consegue passar os niveis de acesso de um usuario
	
	//metodo construtor esta passando o usuario e senha informados para os atributos dessa classe
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//metodo construtor vazio só para garantir o funcionamento da API mesmo quando nao receber esses dados
	public UserDetailsImpl() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
