package com.patrick.chat;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.patrick.chat.domain.Chat;
import com.patrick.chat.domain.Mensagem;
import com.patrick.chat.domain.Usuario;
import com.patrick.chat.domain.enums.Perfil;
import com.patrick.chat.repositories.ChatRepository;
import com.patrick.chat.repositories.MensagemRepository;
import com.patrick.chat.repositories.UsuarioRepository;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private ChatRepository chatRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Mensagem mensagem1 = new Mensagem(null, "oi", 1, 2);
		Mensagem mensagem2 = new Mensagem(null, "oi teste", 2, 2);
		Mensagem mensagem3 = new Mensagem(null, "oi teste", 2, 1);
		
		Chat chat1 = new Chat(null, 1, 2);
		Chat chat2 = new Chat(null, 2, 1);
		Chat chat3 = new Chat(null, 3, 4);
		Chat chat4 = new Chat(null, 4, 3);
		
		Usuario usuario1 = new Usuario(null, "Patrick Araujo", "102.973.977-37","patrick23_costa@hotmail.com",encoder.encode("1234"),"www.html.com.br");
		usuario1.addPerfil(Perfil.ADMIN);
		usuario1.addPerfil(Perfil.USUARIO);
		Usuario usuario2 = new Usuario(null, "Jade", "729.160.110-05","jade@hotmail.com",encoder.encode("1234"),"www.html.com.br");
		
		usuarioRepository.saveAll(Arrays.asList(usuario1));
		usuarioRepository.saveAll(Arrays.asList(usuario2));
		mensagemRepository.saveAll(Arrays.asList(mensagem1));
		mensagemRepository.saveAll(Arrays.asList(mensagem2));
		mensagemRepository.saveAll(Arrays.asList(mensagem3));
		chatRepository.saveAll(Arrays.asList(chat1));
		chatRepository.saveAll(Arrays.asList(chat2));
		chatRepository.saveAll(Arrays.asList(chat3));
		chatRepository.saveAll(Arrays.asList(chat4));
	}

}
