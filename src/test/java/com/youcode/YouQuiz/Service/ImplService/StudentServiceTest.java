package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;
    private StudentDto studentDto;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setBirthDate(LocalDate.now());
        student.setAddress("safi");
        student.setDateInscription(LocalDate.now());

        studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setFirstName("John");
        studentDto.setLastName("Doe");
        student.setBirthDate(LocalDate.now());
        student.setAddress("safi");
        student.setDateInscription(LocalDate.now());
    }

    @Test
    void testCreate() {
        given(modelMapper.map(studentDto, Student.class)).willReturn(student);
        given(modelMapper.map(student, StudentDto.class)).willReturn(studentDto);
        given(studentRepository.save(student)).willReturn(student);
        StudentDto savedStudent = studentService.create(studentDto);
        assertThat(savedStudent).isNotNull();
    }

    @Test
    void testGetAll() {
        List<Student> students = Arrays.asList(student);
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<StudentDto> result = studentService.getAll();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(studentDto, result.get(0));

        // Verify that the repository findAll method was called
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetOne() {
        Long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(modelMapper.map(student, StudentDto.class)).thenReturn(studentDto);

        StudentDto result = studentService.getOne(studentId);

        assertNotNull(result);
        assertEquals(studentDto, result);

        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    void testUpdate() {
        Long studentID = 1L;
        given(studentRepository.findById(studentID)).willReturn(Optional.of(student));
        given(modelMapper.map(student, StudentDto.class)).willReturn(studentDto);
        given(studentRepository.save(student)).willReturn(student);
        StudentDto updatedStudent = studentService.update(studentID, studentDto);
        assertThat(updatedStudent).isNotNull();
        verify(studentRepository).save(student);
    }

    @Test
    void testDelete() {
        Long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        assertDoesNotThrow(() -> studentService.delete(studentId));

        verify(studentRepository, times(1)).findById(studentId);
        verify(studentRepository, times(1)).delete(student);
    }
}