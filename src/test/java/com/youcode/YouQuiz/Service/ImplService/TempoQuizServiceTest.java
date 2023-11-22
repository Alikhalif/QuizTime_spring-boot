package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.TompQuizDto;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.entities.TompQuiz;
import com.youcode.YouQuiz.enums.QuestionType;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.QuizRepository;
import com.youcode.YouQuiz.repositories.TompQuizRepository;
import com.youcode.YouQuiz.tool.TempID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TempoQuizServiceTest {
    @Mock
    private TompQuizRepository tempoQuizRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private TempoQuizServiceImpl tempoQuizService;

    @Mock
    private ModelMapper modelMapper;

    private TompQuiz tempoQuiz;

    private Question question;

    private Quiz quiz;

    private TompQuizDto tempoQuizDto;

    @BeforeEach
    public void setUp() {
        question = Question.builder()
                .id(1L)
                .questionText("question text")
                .type(QuestionType.SINGLE)
                .totalScore(100.00)
                .build();
        quiz = Quiz.builder()
                .id(1L)
                .chanceNum(2)
                .showAnswers(true)
                .showFinalResults(false)
                .score(120.00)
                .remark("remark 1")
                .build();

        tempoQuiz = new TompQuiz();
        tempoQuiz.setQuiz(quiz);
        tempoQuiz.setQuestion(question);
        tempoQuiz.setTime(20);

        tempoQuizDto = new TompQuizDto();
        tempoQuizDto.setQuestion_id(question.getId());
        tempoQuizDto.setQuiz_id(quiz.getId());
        tempoQuizDto.setTime(20);
    }

    @Test
    public void testSuccessSave() {
        given(modelMapper.map(tempoQuizDto, TompQuiz.class)).willReturn(tempoQuiz);
        given(modelMapper.map(tempoQuiz, TompQuizDto.class)).willReturn(tempoQuizDto);
        given(quizRepository.findById(1L)).willReturn(Optional.of(quiz));
        given(questionRepository.findById(1L)).willReturn(Optional.of(question));
        given(tempoQuizRepository.save(tempoQuiz)).willReturn(tempoQuiz);
        TompQuizDto savedTempoQuiz = tempoQuizService.create(tempoQuizDto);
        assertThat(savedTempoQuiz).isNotNull();
    }



    @Test
    public void testSuccessDelete() {
        Long questionID = 1L;
        Long quizID = 1L;
        TempID tempoID = new TempID(quizID, questionID);
        TompQuiz tempoQuiz = new TompQuiz();
        given(tempoQuizRepository.findById(tempoID)).willReturn(Optional.of(tempoQuiz));
        tempoQuizService.delete(questionID, quizID);
        verify(tempoQuizRepository).findById(tempoID);
        verify(tempoQuizRepository).delete(tempoQuiz);
    }


    //@Test
    public void testSuccessUpdate() {
        Long questionID = 1L;
        Long quizID = 1L;
        TempID tempoID = new TempID(quizID, questionID);

        given(tempoQuizRepository.findById(tempoID)).willReturn(Optional.of(tempoQuiz));
        given(tempoQuizRepository.save(tempoQuiz)).willReturn(tempoQuiz);
        TompQuizDto updatedTempoQuiz = tempoQuizService.update(questionID, quizID, tempoQuizDto);

        assertThat(updatedTempoQuiz).isNotNull();
        verify(tempoQuizRepository).findById(tempoID);
        verify(tempoQuizRepository).save(tempoQuiz);
    }

    //@Test
    public void testUpdateWithInvalidTempoID() {
        Long questionID = 1L;
        Long quizID = 1L;
        TempID tempoID = new TempID(quizID, questionID);
        TompQuizDto updatedTempoQuizDto = new TompQuizDto();
        updatedTempoQuizDto.setQuiz_id(quizID);
        updatedTempoQuizDto.setQuestion_id(questionID);
        updatedTempoQuizDto.setTime(30);
        given(tempoQuizRepository.findById(tempoID)).willReturn(Optional.empty());
        given(tempoQuizService.update(quizID,questionID, updatedTempoQuizDto)).willReturn(tempoQuizDto);

        verify(tempoQuizRepository).findById(tempoID);
        verify(tempoQuizRepository, never()).save(any(TompQuiz.class));

    }



}
