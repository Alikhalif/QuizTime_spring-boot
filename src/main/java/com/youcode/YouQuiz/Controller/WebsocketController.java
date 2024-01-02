package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.dto.ChatMessageDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessageDto chat(@DestinationVariable String roomId, ChatMessageDto chatMessageDto){
        return new ChatMessageDto(
                chatMessageDto.getMessage(),
                chatMessageDto.getUser()
        );
    }
}
