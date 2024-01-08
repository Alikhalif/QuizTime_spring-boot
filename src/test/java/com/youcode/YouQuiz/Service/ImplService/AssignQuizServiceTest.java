package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.*;
import com.youcode.YouQuiz.dto.TempoResponse.AssignQuizDtoResponse;
import com.youcode.YouQuiz.entities.AssignQuiz;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.entities.Trainer;
import com.youcode.YouQuiz.repositories.AssignQuizRepository;
import com.youcode.YouQuiz.repositories.QuizRepository;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AssignQuizServiceTest {
    @Mock
    private AssignQuizRepository assignQuizRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AssignQuizServiceImpl assignQuizService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private QuizRepository quizRepository;

    private Student student;

    private StudentDto studentDto;

    private Quiz quiz;

    private QuizDto quizDto;

    private AssignQuiz assignQuiz;

    private AssignQuizDto assignQuizDto;

    //private AssignQuizDtoResponse assignQuizDtoResponse;

    private Trainer trainer;

    private TrainerDto trainerDto;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("hassan");
        student.setLastName("essadik");
        student.setBirthDate(LocalDate.now());
        student.setAddress("safi");
        student.setDateInscription(LocalDate.now());

        studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setFirstName("hassan");
        studentDto.setLastName("essadik");
        studentDto.setBirthDate(LocalDate.now());
        studentDto.setAddress("safi");
        studentDto.setDateInscription(LocalDate.now());

        trainer = new Trainer();
        trainer.setId(1L);
        trainer.setFirstName("hassan");
        trainer.setLastName("essadik");
        trainer.setBirthDate(LocalDate.now());
        trainer.setAddress("safi");

        trainerDto = new TrainerDto();
        trainerDto.setId(1L);
        trainerDto.setFirstName("hassan");
        trainerDto.setLastName("essadik");
        trainerDto.setBirthDate(LocalDate.now());
        trainerDto.setAddress("safi");

        quiz = Quiz.builder()
                .id(1L)
                .chanceNum(2)
                .showAnswers(true)
                .showFinalResults(false)
                .score(120.00)
                .remark("remark 1")
                .trainer(trainer)
                .build();

        quizDto = new QuizDto();
        quizDto.setScore(120.00);
        quizDto.setRemark("remark 1");
        quizDto.setChanceNum(2);
        quizDto.setShowAnswers(false);
        quizDto.setShowFinalResults(false);

        assignQuiz = AssignQuiz.builder()
                .id(1L)
                .score(null)
                .reason("reason")
                //.result(Result.PASS)
                .debutDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .quiz(quiz)
                .student(student)
                .build();
        assignQuizDto = new AssignQuizDto();
        assignQuizDto.setId(1L);
        assignQuizDto.setScore(null);
        //assignQuizDto.setResult(Result.PASS);
        assignQuizDto.setReason("reason");
        assignQuizDto.setDebutDate(LocalDateTime.now());
        assignQuizDto.setEndDate(LocalDateTime.now());
        assignQuizDto.setQuiz_id(quiz.getId());
        assignQuizDto.setStudent_id(student.getId());
    }

    @Test
    public void testSuccessSaveAll() {
        given(quizRepository.findById(anyLong())).willReturn(Optional.of(new Quiz()));
        given(studentRepository.findById(anyLong())).willReturn(Optional.of(new Student()));

        AssignQuiz savedAssignQuiz = new AssignQuiz();
        given(assignQuizRepository.save(any(AssignQuiz.class))).willReturn(savedAssignQuiz);

        given(modelMapper.map(any(AssignQuizDto.class), eq(AssignQuiz.class))).willReturn(new AssignQuiz());
        given(modelMapper.map(any(AssignQuiz.class), eq(AssignQuizDto.class))).willReturn(new AssignQuizDto());
        AssignQuizDto assignQuizDto1 = new AssignQuizDto();
        assignQuizDto1.setQuiz_id(1L);
        assignQuizDto1.setStudent_id(2L);

        AssignQuizDto assignQuizDto2 = new AssignQuizDto();
        assignQuizDto2.setQuiz_id(3L);
        assignQuizDto2.setStudent_id(4L);

        List<AssignQuizDto> assignQuizDtoList = Arrays.asList(assignQuizDto1, assignQuizDto2);
        List<AssignQuizDto> result = assignQuizService.create(assignQuizDtoList);
        assertThat(result).isNotNull().hasSize(2);
    }


    //@Test
    public void testGetAll() {

        List<AssignQuizDto> list = new ArrayList<>();
        list.add(assignQuizDto);
        when(assignQuizService.getAll()).thenReturn(list);
        List<AssignQuizDto> tmp = assignQuizService.getAll();
        assertEquals(tmp.size(), list.size());
    }

    @DisplayName("Test getAll assignments method when the list is empty")
    @Test
    public void testEmptyGetAll() {
        given(assignQuizRepository.findAll()).willReturn(Collections.emptyList());
        List<AssignQuizDto> allAssignments = assignQuizService.getAll();
        assertThat(allAssignments).isEmpty();
    }

    @DisplayName("Test delete assignment method with valid ID")
    //@Test
    public void testSuccessDelete() {
        Long assignmentID = 1L;
        given(assignQuizRepository.findById(assignmentID)).willReturn(Optional.of(assignQuiz));
        willDoNothing().given(assignQuizRepository).delete(assignQuiz);
        assignQuizService.delete(assignmentID);
        verify(assignQuizRepository, times(1)).delete(assignQuiz);
    }



    @DisplayName("Test findByID assignment method when the id is valid")
    @Test
    public void testSuccessFindByID() {
        Long assignmentID = 1L;
        given(assignQuizRepository.findById(assignmentID)).willReturn(Optional.of(assignQuiz));
        given(modelMapper.map(assignQuiz, AssignQuizDto.class)).willReturn(assignQuizDto);

        AssignQuizDtoResponse foundAssignment = assignQuizService.getOne(assignmentID);
        verify(assignQuizRepository).findById(assignmentID);
        assertThat(foundAssignment).isNotNull();
    }


    @DisplayName("Test update assignment method in a success scenario")
    @Test
    public void testSuccessUpdate() {
        Long assignmentID = 1L;
        given(assignQuizRepository.findById(assignmentID)).willReturn(Optional.of(assignQuiz));
        given(quizRepository.findById(1L)).willReturn(Optional.of(quiz));
        given(studentRepository.findById(1L)).willReturn(Optional.of(student));
        given(modelMapper.map(assignQuiz, AssignQuizDto.class)).willReturn(assignQuizDto);
        given(assignQuizRepository.save(assignQuiz)).willReturn(assignQuiz);
        AssignQuizDto updatedAssignment = assignQuizService.update(assignmentID, assignQuizDto);
        assertThat(updatedAssignment).isNotNull();
    }

}
