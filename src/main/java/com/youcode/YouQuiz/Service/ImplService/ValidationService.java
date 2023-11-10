package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.ValidationServiceImpl;
import com.youcode.YouQuiz.dto.ValidationDto;
import com.youcode.YouQuiz.entities.Answar;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Validation;
import com.youcode.YouQuiz.repositories.AnswarRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService implements ValidationServiceImpl {
    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswarRepository answarRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ValidationDto create(ValidationDto validationDto){
        Validation validation = modelMapper.map(validationDto, Validation.class);

        if (validationDto.getQuestion_id() != null){
            Question question = questionRepository.findById(validationDto.getQuestion_id()).get();
            validation.setQuestion(question);
        }
        if (validationDto.getAnswar_id() != null){
            Answar answar = answarRepository.findById(validationDto.getAnswar_id()).get();
            validation.setAnswar(answar);
        }

        validation = validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDto.class);

    }
}
