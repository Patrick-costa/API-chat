package com.patrick.chat.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.chat.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findById(String id);
}
