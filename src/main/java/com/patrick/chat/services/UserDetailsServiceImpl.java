package com.patrick.chat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.patrick.chat.domain.Usuario;
import com.patrick.chat.repositories.UsuarioRepository;

import com.patrick.chat.security.UseSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	public Integer idUser;
	private Integer teste;
	

	public UserDetailsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserDetailsServiceImpl(Integer idUser) {
		super();
		this.idUser = this.teste;
	}



	public Integer getIdUser() {
		return idUser;
	}



	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByEmail(email);
		setIdUser(user.get().getId());
		System.out.println("##############################################");
		System.out.println(getIdUser());
		if(user.isPresent()) {
			return new UseSS(user.get().getId(), user.get().getEmail(), user.get().getSenha());
		}
		

		
		throw new UsernameNotFoundException(email);
	}

}
