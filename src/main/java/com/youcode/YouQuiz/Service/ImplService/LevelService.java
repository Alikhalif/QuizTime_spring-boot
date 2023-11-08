package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.dto.LevelDto;
import com.youcode.YouQuiz.entities.Level;
import com.youcode.YouQuiz.repositories.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LevelDto create(LevelDto levelDto){
        Level level = modelMapper.map(levelDto, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDto.class);
    }

    public List<LevelDto> getAll(){
        return Arrays.asList(modelMapper.map(levelRepository.findAll(), LevelDto[].class));
    }
}
