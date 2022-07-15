package com.patrick.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.chat.domain.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {

}
