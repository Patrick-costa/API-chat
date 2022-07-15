 package com.patrick.chat.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;


import com.patrick.chat.domain.dtos.UsuarioDTO;
import com.patrick.chat.domain.enums.Perfil;


@Entity
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	
	@ElementCollection(fetch = FetchType.EAGER) 
	private List<Mensagem> mensagem = new ArrayList<>();
	
	@CPF
	@Column(unique = true)
	protected String cpf;
	
	@Column(unique = true)
	protected String email;
	
	protected String senha;
	protected String fotoURL;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		super();
		addPerfil(Perfil.USUARIO);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Usuario(Integer id, String nome, String cpf, String email, String senha,
			String fotoURL) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.fotoURL = fotoURL;
	}




	public Usuario(UsuarioDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.fotoURL = obj.getFotoURL();
		this.mensagem = obj.getMensagem();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getId());
	}
	
	public List<Mensagem> getMensagem() {
		return mensagem;
	}


	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}



	
	
	
}
