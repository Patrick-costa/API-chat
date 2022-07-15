package com.patrick.chat.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.patrick.chat.domain.Mensagem;

import com.patrick.chat.domain.dtos.MensagemDTO;

import com.patrick.chat.repositories.MensagemRepository;




@Service
public class MensagemService {

	@Autowired
	private MensagemRepository repository;
	
	@Autowired
	UserDetailsServiceImpl userDet;

	private List<Mensagem> list;

	
	public Mensagem findById(Integer id) {
		Optional<Mensagem> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Mensagem> findAll() {
		List<Mensagem> mensagem = repository.findAll();
		return mensagem.stream().filter((x) -> x.getIdRemetente().equals(userDet.getIdUser()) || x.getIdDestinatario().equals(userDet.getIdUser()) ).collect(Collectors.toList());
	}
	

	public Mensagem create(MensagemDTO objDTO) {
	
		return repository.save(newMensagem(objDTO));
	}
	
	public void delete(Integer id) {
		System.out.println("##############################################");
		System.out.println(id);
		repository.deleteById(id);
	}
	
	
	public Mensagem update(Integer id, MensagemDTO objDTO) {
			objDTO.setId(id);
			Mensagem oldObj = findById(id);
			oldObj = newMensagem(objDTO);
			
			list = new ArrayList<Mensagem>();
			list = findAll();
			
			for(Mensagem x : list) {
				if(id == x.getId()) {
					return repository.save(oldObj);
				}
			}
			
			return null;
		
	}
	
	
	
	private Mensagem newMensagem(MensagemDTO obj) {
		
		Mensagem mensagem = new Mensagem();	
		
		if(obj.getId() != null) {
			System.out.println("##############################################");
			mensagem.setId(null);
		}
		
		mensagem.setMensagem(obj.getMensagem());
		mensagem.setIdRemetente(userDet.getIdUser());
		mensagem.setIdDestinatario(obj.getIdDestinatario());
		mensagem.setStatus(obj.getStatus());
		
		return mensagem;
	}
	
}
