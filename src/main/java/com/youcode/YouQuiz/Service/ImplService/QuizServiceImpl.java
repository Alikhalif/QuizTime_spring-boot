package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.repositories.QuizRepository;
import com.youcode.YouQuiz.repositories.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public QuizDto create(QuizDto quizDto){
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDto.class);
    }


    public QuizDto update(Long id, QuizDto quizDto){
        if(quizRepository.existsById(id)){
            Quiz quiz = modelMapper.map(quizDto, Quiz.class);
            quiz.setId(id);
            quiz.setTrainer(
                    trainerRepository.findById(quizDto.getTrainerId()).get()
            );
            Quiz quizUpdated = quizRepository.save(quiz);
            return modelMapper.map(quizUpdated, QuizDto.class);
        }else {
            try {
                throw new EntityNotFoundException("Student Not Found with id : "+ id);
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
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

    public List<QuizDto> getAll(){
        return Arrays.asList(modelMapper.map(quizRepository.findAll(), QuizDto[].class));
    }

    public Optional<QuizDto> getOne(Long id){
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        return quizOptional.map(quiz ->{
            QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
            return Optional.ofNullable(quizDto);
        }).orElseGet(Optional::empty);
    }




}
