package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.dto.MediaDto;
import com.youcode.YouQuiz.entities.Media;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.enums.MediaType;
import com.youcode.YouQuiz.repositories.MediaRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MediaServiceTest {

    @Mock
    private MediaRepository mediaRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private MediaServiceImpl mediaService;

    private MediaDto mediaDto;
    private Media media;
    private Question question;


    @BeforeEach
    public void setUp() {
        mediaDto = new MediaDto();
        mediaDto.setId(1);
        mediaDto.setUrl("https://image.com");
        mediaDto.setMediaType(MediaType.IMAGE);
        mediaDto.setQuestion_id(1L);

        question = new Question();
        question.setId(1L);

        media = new Media();
        media.setId(1);
        media.setUrl("https://image.com");
        media.setMediaType(MediaType.IMAGE);
        media.setQuestion(question);
    }


    @Test
    public void testCreate() {
        when(modelMapper.map(mediaDto, Media.class)).thenReturn(media);
        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(mediaRepository.save(any(Media.class))).thenReturn(media);

        // When
        MediaDto result = mediaService.create(mediaDto);

        // Then
        assertNotNull(result); // This assertion is failing
        assertEquals(mediaDto.getId(), result.getId());
        assertEquals(mediaDto.getUrl(), result.getUrl());
        assertEquals(mediaDto.getMediaType(), result.getMediaType());
        assertEquals(mediaDto.getQuestion_id(), result.getQuestion_id());

        // Optionally, you can verify that the repository methods were called
        verify(modelMapper, times(1)).map(mediaDto, Media.class);
        verify(questionRepository, times(1)).findById(1L);
        verify(mediaRepository, times(1)).save(any(Media.class));
    }

    @Test
    public void testDelete() {
        // Given
        when(mediaRepository.findById(1)).thenReturn(Optional.of(media));

        // When
        assertDoesNotThrow(() -> mediaService.delete(1));

        // Optionally, you can verify that the repository method was called
        verify(mediaRepository, times(1)).findById(1);
        verify(mediaRepository, times(1)).delete(media);
    }

}
