package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.dto.AnswarDto;
import com.youcode.YouQuiz.dto.ValidationDto;
import com.youcode.YouQuiz.entities.Answar;
import com.youcode.YouQuiz.repositories.AnswarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnswarServiceTest {
    @Mock
    private AnswarRepository answarRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private AnswarServiceImpl answarService;

    private Answar answar;
    private AnswarDto answarDto;


    @BeforeEach
    void setUp() {
        answar = new Answar();
        answar.setId(1L);
        answar.setAnswareText("Sample Answer");

        answarDto = new AnswarDto();
        answarDto.setId(1L);
        answarDto.setAnswareText("Sample Answer");
        answarDto.setPoints(2.0);
        answarDto.setCheckAnswar(true);
        answarDto.setQuestion_id(1L);
    }

    @Test
    void testCreate() {
        when(modelMapper.map(answarDto, Answar.class)).thenReturn(answar);
        when(answarRepository.save(answar)).thenReturn(answar);
        AnswarDto result = answarService.create(answarDto);
        assertNull(result);
        verify(answarRepository, times(1)).save(answar);
        verify(validationService, times(1)).create(any(ValidationDto.class));
    }



    @Test
    void testGetOne() {
        Long answarId = 1L;
        when(answarRepository.findById(answarId)).thenReturn(Optional.of(answar));
        when(modelMapper.map(answar, AnswarDto.class)).thenReturn(answarDto);

        AnswarDto result = answarService.getOne(answarId);

        assertNotNull(result);
        assertEquals(answarDto, result);

        verify(answarRepository, times(1)).findById(answarId);
    }


    @Test
    void testUpdate() {
        Long answarId = 1L;
        lenient().when(answarRepository.findById(answarId)).thenReturn(Optional.of(answar));
        lenient().when(modelMapper.map(answarDto, Answar.class)).thenReturn(answar);
        lenient().when(answarRepository.save(answar)).thenReturn(answar);
        lenient().when(modelMapper.map(answar, AnswarDto.class)).thenReturn(answarDto);
        AnswarDto result = answarService.update(answarId, answarDto);
        assertNotNull(result);
        assertEquals(answarDto, result);
        verify(answarRepository, times(1)).findById(answarId);
        verify(answarRepository, times(1)).save(answar);
    }


    @Test
    void testDelete() {
        Long answarId = 1L;
        when(answarRepository.findById(answarId)).thenReturn(Optional.of(answar));
        assertDoesNotThrow(() -> answarService.delete(answarId));
        verify(answarRepository, times(1)).findById(answarId);
        verify(answarRepository, times(1)).delete(answar);
    }
}
