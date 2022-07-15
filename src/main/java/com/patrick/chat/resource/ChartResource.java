package com.patrick.chat.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.chat.domain.Chat;
import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.dtos.ChatDTO;
import com.patrick.chat.domain.dtos.MensagemDTO;
import com.patrick.chat.services.ChatService;

@RestController
@RequestMapping(value = "/chats")
public class ChartResource {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping
	public ResponseEntity<List<ChatDTO>> findAll(){
		List<Chat> list = chatService.findAll();
		List<ChatDTO> listDTO = list.stream().map(obj -> new ChatDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
