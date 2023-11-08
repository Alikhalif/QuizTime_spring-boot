package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.repositories.QuizRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;

    public QuizDto create(QuizDto quizDto){
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDto.class);
    }

    public void delete(Long id){
        if (quizRepository.existsById(id)){
            quizRepository.deleteById(id);
        }else {
            try{
                throw new EntityNotFoundException("Quiz not found with id : "+id);
            }catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
