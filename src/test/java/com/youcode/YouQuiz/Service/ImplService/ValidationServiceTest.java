package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.ValidationServiceImpl;
import com.youcode.YouQuiz.dto.AnswarDto;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.dto.ValidationDto;
import com.youcode.YouQuiz.entities.Answar;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Validation;
import com.youcode.YouQuiz.enums.QuestionType;
import com.youcode.YouQuiz.repositories.AnswarRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.ValidationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {
    @Mock
    private ValidationRepository validationRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswarRepository answarRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ValidationService validationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateValidation() {
        // Create a ValidationDto for testing
        ValidationDto validationDto = new ValidationDto();
        validationDto.setPoints(2.0);
        validationDto.setCheckAnswar(true);
        validationDto.setQuestion_id(1L);
        validationDto.setAnswar_id(2L);

        // Create a Question for testing
        Question question = new Question();
        question.setId(1L);

        // Create an Answar for testing
        Answar answar = new Answar();
        answar.setId(2L);

        // Create a Validation entity for testing
        Validation validation = new Validation();
        validation.setId(3L);

        // Mock the behavior of the repositories
        given(questionRepository.findById(1L)).willReturn(Optional.of(question));
        given(answarRepository.findById(2L)).willReturn(Optional.of(answar));

        // Mock the behavior of the model mapper
        when(modelMapper.map(validationDto, Validation.class)).thenReturn(validation);

        // Perform the service method
        ValidationDto result = validationService.create(validationDto);

        // Verify the result
        assertEquals(3L, result.getId());
    }
}
