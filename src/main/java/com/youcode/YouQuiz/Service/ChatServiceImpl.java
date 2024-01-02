package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.ChatDto;
import com.youcode.YouQuiz.entities.Chat;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.ChatRepository;
import com.youcode.YouQuiz.repositories.StudentRepository;
import com.youcode.YouQuiz.repositories.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public ChatDto save(ChatDto chatDto){
        Chat chatModel = modelMapper.map(chatDto, Chat.class);
        chatModel.setStudent(
                studentRepository.findById(chatDto.getStudent_id()).get()
        );
        chatModel.setTrainer(
                trainerRepository.findById(chatDto.getTrainer_id()).get()
        );
        chatModel = chatRepository.save(chatModel);
        return modelMapper.map(chatModel, ChatDto.class);
    }
}
