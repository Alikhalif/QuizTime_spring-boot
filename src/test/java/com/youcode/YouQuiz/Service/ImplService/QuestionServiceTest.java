package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.QuestionService;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.enums.QuestionType;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @Mock
    private QuestionService questionService;
    private QuestionDto questionDTO;
    @BeforeEach
    private void init(){
        questionDTO = new QuestionDto();
        questionDTO.setId(1L);
        questionDTO.setType(QuestionType.SINGLE);
        questionDTO.setTotalScore(1.0);
        questionDTO.setQuestionText("test");


    }

    @Test
    void create() {
        try{
            when(questionService.create(questionDTO)).thenReturn(questionDTO);
            QuestionDto tmp = questionService.create(questionDTO);
            assertEquals(questionDTO.getId(), tmp.getId());
        }catch (NotFoundException ex){}
    }

    @Test
    void update() {
        try{
            questionDTO.setQuestionText("test*");
            when(questionService.update(1L, questionDTO)).thenReturn(questionDTO);
            QuestionDto tmp = questionService.update(1L, questionDTO);
            assertEquals(questionDTO.getId(), tmp.getId());
        }catch (NotFoundException ex){}
    }



    @Test
    void findAll() {
        List<QuestionDto> list = new ArrayList<>();
        list.add(questionDTO);
        when(questionService.getAll()).thenReturn(list);
        assertEquals(questionService.getAll(), list);
    }
}
