package com.patrick.chat.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.Usuario;
import com.patrick.chat.domain.enums.Perfil;


public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O campo NOME é requirido")
	protected String nome;
	@NotNull(message = "O campo CPF é requirido")
	protected String cpf;
	@NotNull(message = "O campo EMAIL é requirido")
	protected String email;
	@NotNull(message = "O campo SENHA é requirido")
	protected String senha;
	@NotNull(message = "O campo FOTOURL é requirido")
	protected String fotoURL;
	protected Set<Integer> perfis = new HashSet<>();
	
	protected List<Mensagem> mensagem = new ArrayList<>();
	

	public UsuarioDTO(Usuario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getId()).collect(Collectors.toSet());
		this.fotoURL = obj.getFotoURL();
		this.mensagem = obj.getMensagem();
	}
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
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

}
