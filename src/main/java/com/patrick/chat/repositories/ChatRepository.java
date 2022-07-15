package com.patrick.chat.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.patrick.chat.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
