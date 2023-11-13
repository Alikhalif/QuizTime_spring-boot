package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.dto.SubjectDto;
import com.youcode.YouQuiz.entities.Subject;
import com.youcode.YouQuiz.repositories.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubjectService {
    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    private SubjectDto subjectDto;
    private Subject subject;


    @BeforeEach
    private void setUp(){
        subjectDto = new SubjectDto();
        subjectDto.setId(1L);
        subjectDto.setTitle("subject");

        subject = new Subject();
        subject.setId(1L);
        subject.setTitle("Test Subject");
    }

    @Test
    public void createTest(){
        when(subjectService.create(subjectDto)).thenReturn(subjectDto);
        SubjectDto sub = subjectService.create(subjectDto);
        assertSame(sub, subjectDto);
    }


    @Test
    public void deleteTest(){
        Long subjectId = 1L;
        Subject testSubject = new Subject();
        testSubject.setId(subjectId);
        testSubject.setTitle("Test Subject");

        when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(testSubject));
        subjectService.delete(subjectId);
    }

    @Test
    public void testGetOne() {
        // Mocking the behavior of the repository
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));

        // Mocking the behavior of the modelMapper
        when(modelMapper.map(subject, SubjectDto.class)).thenReturn(subjectDto);

        // When
        SubjectDto result = subjectService.getOne(1L);

        // Then
        assertNotNull(result);
        assertEquals(subjectDto.getId(), result.getId());
        assertEquals(subjectDto.getTitle(), result.getTitle());

        verify(subjectRepository, times(1)).findById(1L);
    }



    @Test
    public void testGetAll() {
        List<Subject> subjectList = Arrays.asList(subject);
        when(subjectRepository.findAll()).thenReturn(subjectList);
        when(modelMapper.map(subjectList, SubjectDto[].class)).thenReturn(new SubjectDto[]{subjectDto});

        // When
        List<SubjectDto> resultList = subjectService.getAll();

        // Then
        assertNotNull(resultList);
        assertEquals(1, resultList.size());

        // Optionally, you can verify that the repository method was called
        verify(subjectRepository, times(1)).findAll();
        verify(modelMapper, times(1)).map(subjectList, SubjectDto[].class);
    }


}
