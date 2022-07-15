package com.patrick.chat.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patrick.chat.domain.Mensagem;

import com.patrick.chat.domain.dtos.MensagemDTO;
import com.patrick.chat.services.MensagemService;



@RestController
@RequestMapping(value = "/mensagem")
public class MensagemResource {
	
	@Autowired
	private MensagemService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MensagemDTO> findById(@PathVariable Integer id){
		Mensagem obj = service.findById(id);
		return ResponseEntity.ok().body(new MensagemDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<MensagemDTO>> findAll(){
		List<Mensagem> list = service.findAll();
		List<MensagemDTO> listDTO = list.stream().map(obj -> new MensagemDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MensagemDTO> create(@Valid @RequestBody MensagemDTO objDTO){
		Mensagem obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MensagemDTO> update(@PathVariable Integer id, @Valid @RequestBody MensagemDTO objDTO){
		Mensagem newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new MensagemDTO(newObj));
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<MensagemDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
