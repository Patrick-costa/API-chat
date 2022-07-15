package com.patrick.chat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.Usuario;
import com.patrick.chat.domain.dtos.UsuarioDTO;
import com.patrick.chat.repositories.MensagemRepository;
import com.patrick.chat.repositories.UsuarioRepository;
import com.patrick.chat.security.UseSS;
import com.patrick.chat.services.exceptions.DataIntegrityViolationException;
import com.patrick.chat.services.exceptions.ObjectnotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private MensagemRepository mensagemRepository;

	@Autowired
	UserDetailsServiceImpl userDet;
	
	public List<Mensagem> findAllMensagem(){
		return mensagemRepository.findAll();
	}

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	private void validaPorCPfEEmail(UsuarioDTO objDTO) {
		Optional<Usuario> obj = repository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema");		
		}
		
		obj = repository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado");
		}
	}

	public Usuario create(UsuarioDTO objDTO) {
		objDTO.setSenha(objDTO.getSenha());
		objDTO.setId(null);
		validaPorCPfEEmail(objDTO);
		Usuario newObj = new Usuario(objDTO);
		return repository.save(newObj);
		
	}
	
	
	public Usuario update(Integer id, UsuarioDTO objDTO) {
		objDTO.setId(id);
		Usuario oldObj = findById(id);
		oldObj = new Usuario(objDTO);
		oldObj.setMensagem(listarMensagens());
		validaPorCPfEEmail(objDTO);
		return repository.save(oldObj);
		
	}
	

	public List<Mensagem> listarMensagens() {
		List<Mensagem> listMensagem = new ArrayList<Mensagem>();
		listMensagem = findAllMensagem();
		return listMensagem;
		
	}
	

	
}
