package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.TrainerService;
import com.youcode.YouQuiz.dto.TrainerDto;
import com.youcode.YouQuiz.entities.Trainer;
import com.youcode.YouQuiz.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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

    public List<Trainer> getAll(){
        return trainerRepository.findAll();
    }

    public Trainer update(Long id, TrainerDto trainerDto){
        Trainer trainer = trainerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Trainer Not Found !"));
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setBirthDate(trainerDto.getBirthDate());
        trainer.setAddress(trainerDto.getAddress());
        trainer.setSpeciality(trainerDto.getSpeciality());
        return trainerRepository.save(trainer);
    }
}
