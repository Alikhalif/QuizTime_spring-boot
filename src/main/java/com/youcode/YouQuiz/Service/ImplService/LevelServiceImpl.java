package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.Service.LevelService;
import com.youcode.YouQuiz.dto.LevelDto;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Level;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LevelDto create(LevelDto levelDto){
        Level level = modelMapper.map(levelDto, Level.class);
        level = levelRepository.save(level);
        return modelMapper.map(level, LevelDto.class);
    }

    @Override
    public List<LevelDto> getAll(){
        return Arrays.asList(modelMapper.map(levelRepository.findAll(), LevelDto[].class));
    }

    @Override
    public LevelDto getOne(Long id) throws EntityNotFoundException {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found level with id : "+id));
        return modelMapper.map(level, LevelDto.class);
    }

    @Override
    public void delete(Long id){
        if (levelRepository.existsById(id)){
            levelRepository.deleteById(id);
        }else {
            try{
                throw new EntityNotFoundException("Level not found with id : "+id);
            }catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public LevelDto update(Long id, LevelDto levelDto) {
        Level level = modelMapper.map(levelDto, Level.class);
        level.setId(id);
        Level updatedLevel = levelRepository.save(level);
        return modelMapper.map(updatedLevel, LevelDto.class);
    }
}
