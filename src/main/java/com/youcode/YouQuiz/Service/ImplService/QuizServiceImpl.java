package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.Service.QuizService;
import com.youcode.YouQuiz.dto.QuizDto;
import com.youcode.YouQuiz.entities.Level;
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
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public QuizDto create(QuizDto quizDto){
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDto.class);
    }

    @Override
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

    @Override
    public void delete(Long id){
        Quiz quiz = null;
        try {
            quiz = quizRepository.findById(id)
                    .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        quizRepository.delete(quiz);
    }

    @Override
    public List<QuizDto> getAll(){
        return Arrays.asList(modelMapper.map(quizRepository.findAll(), QuizDto[].class));
    }

    @Override
    public Optional<QuizDto> getOne(Long id){
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        return quizOptional.map(quiz ->{
            QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
            return Optional.ofNullable(quizDto);
        }).orElseGet(Optional::empty);
    }




}
