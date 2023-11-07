package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import com.youcode.YouQuiz.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer create(TrainerDto trainerDto){
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setBirthDate(trainerDto.getBirthDate());
        trainer.setAddress(trainerDto.getAddress());
        trainer.setSpeciality(trainerDto.getSpeciality());
        return trainerRepository.save(trainer);
    }
}
