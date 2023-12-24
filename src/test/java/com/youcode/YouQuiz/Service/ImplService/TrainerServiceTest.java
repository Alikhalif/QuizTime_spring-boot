package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import com.youcode.YouQuiz.repositories.TrainerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private TrainerRepository trainerRepository;

    @InjectMocks
    private TrainerServiceImpl trainerService;

    private Trainer trainer;

    private TrainerDto trainerDto;


    @BeforeEach
    public void setUp() {
        trainer = new Trainer();
        trainer.setId(1L);
        trainer.setFirstName("ali");
        trainer.setLastName("khalif");
        trainer.setBirthDate(LocalDate.now());
        trainer.setAddress("safi");

        trainerDto = new TrainerDto();
        trainerDto.setId(1L);
        trainerDto.setFirstName("ali");
        trainerDto.setLastName("khalif");
        trainerDto.setBirthDate(LocalDate.now());
        trainerDto.setAddress("safi");
    }

    @Test
    public void testSave() {
        given(modelMapper.map(trainerDto, Trainer.class)).willReturn(trainer);
        given(modelMapper.map(trainer, TrainerDto.class)).willReturn(trainerDto);
        given(trainerRepository.save(trainer)).willReturn(trainer);
        Trainer savedTrainer = trainerService.create(trainerDto);
        assertThat(savedTrainer).isNotNull();
    }

    @Test
    public void testSuccessDelete() {
        Long trainerID = 1L;
        given(trainerRepository.findById(trainerID)).willReturn(Optional.of(trainer));
        willDoNothing().given(trainerRepository).delete(trainer);
        trainerService.delete(trainerID);
        verify(trainerRepository, times(1)).delete(trainer);
    }

    @Test
    public void testGetFilledAll() {
        Trainer trainer1 = new Trainer();
        trainer1.setFirstName("mouad");
        trainer1.setLastName("mohammed");
        trainer1.setBirthDate(LocalDate.now());
        trainer1.setAddress("safi");

        given(trainerRepository.findAll()).willReturn(List.of(trainer, trainer1));
        given(modelMapper.map(trainer, TrainerDto.class)).willReturn(trainerDto);
        List<TrainerDto> allTrainers = trainerService.getAll();
        assertThat(allTrainers).isNotNull();

    }

    @Test
    public void testSuccessFindByID() {
        Long trainerID = 1L;
        given(trainerRepository.findById(trainerID)).willReturn(Optional.of(trainer));
        given(modelMapper.map(trainer, TrainerDto.class)).willReturn(trainerDto);

        TrainerDto foundTrainer = trainerService.getOne(trainerID);

        verify(trainerRepository).findById(trainerID);

        assertThat(foundTrainer).isNotNull();
    }

    @Test
    public void testSuccessUpdate() {
        Long trainerID = 1L;
        given(trainerRepository.findById(trainerID)).willReturn(Optional.of(trainer));
        given(modelMapper.map(trainer, TrainerDto.class)).willReturn(trainerDto);
        given(trainerRepository.save(trainer)).willReturn(trainer);
        Trainer updatedTrainer = trainerService.update(trainerID, trainerDto);
        assertThat(updatedTrainer).isNotNull();
        verify(trainerRepository).save(trainer);
    }


}
