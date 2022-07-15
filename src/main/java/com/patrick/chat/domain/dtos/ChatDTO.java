package com.patrick.chat.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrick.chat.domain.Chat;
import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.services.MensagemService;
import com.patrick.chat.services.UserDetailsServiceImpl;


public class ChatDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MensagemService mensagemService;
	
	@Autowired
	private UserDetailsServiceImpl userDet;
	
	private Integer id;
	private Integer idRemetente;
	private Integer idDestinatario;
	private List<Mensagem> mensagem = new ArrayList<>();
	
	public ChatDTO(Chat obj) {
		super();
		this.id = obj.getId();
		this.idRemetente = obj.getIdRemetente();
		this.idDestinatario = obj.getIdDestinatario();
		this.mensagem = obj.getMensagem();
	}
	
	public ChatDTO() {
		super();
		System.out.println("###########################################################");
		System.out.println("SUPERCLASS"); 
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(Integer idRemetente) {
		this.idRemetente = idRemetente;
	}
	public Integer getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(Integer idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public List<Mensagem> getMensagem() {
		return mensagem;
	}
	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}
	
	public List<Mensagem> listarMensagens() {
		List<Mensagem> listMensagem = new ArrayList<Mensagem>();
		listMensagem = mensagemService.findAll();
		return listMensagem.stream().filter(x -> x.getIdRemetente().equals(userDet.getIdUser()) || x.getIdDestinatario().equals(userDet.getIdUser())).collect(Collectors.toList());
	}
	
	
}
