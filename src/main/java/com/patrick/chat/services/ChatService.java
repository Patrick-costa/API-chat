package com.patrick.chat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrick.chat.domain.Chat;
import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.Usuario;
import com.patrick.chat.domain.dtos.ChatDTO;
import com.patrick.chat.repositories.ChatRepository;
import com.patrick.chat.services.exceptions.ObjectnotFoundException;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private MensagemService mensagemService;
	
	
	@Autowired
	UserDetailsServiceImpl userDet;
	
	public Chat findById(Integer id) {
		Optional<Chat> obj = chatRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public List<Chat> findAll(){
		List<Chat> chat = chatRepository.findAll();
		return chat.stream().filter(x -> x.getIdRemetente().equals(userDet.getIdUser()) || x.getIdDestinatario().equals(userDet.getIdUser())).collect(Collectors.toList());
	}
	
	

}
