package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ChatService;
import com.youcode.YouQuiz.dto.ChatDto;
import com.youcode.YouQuiz.dto.ChatMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    public void chat(ChatDto chatMessageDto){
        System.out.println(chatMessageDto.getMessage());
        ChatDto chat = chatService.save(chatMessageDto);
        String channel = String.format("%d-%d", chatMessageDto.getTrainer_id(), chatMessageDto.getStudent_id());
        System.out.println(channel);
        messagingTemplate.convertAndSendToUser(channel, "/queue/messages", chat);
    }
}
