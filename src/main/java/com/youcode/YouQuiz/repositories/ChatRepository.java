package com.youcode.YouQuiz.repositories;

import com.youcode.YouQuiz.dto.ChatDto;
import com.youcode.YouQuiz.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
