package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.AnswarService;
import com.youcode.YouQuiz.dto.AnswarDto;
import com.youcode.YouQuiz.dto.ValidationDto;
import com.youcode.YouQuiz.entities.Answar;
import com.youcode.YouQuiz.entities.Validation;
import com.youcode.YouQuiz.repositories.AnswarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswarServiceImpl implements AnswarService {

    @Autowired
    private AnswarRepository answarRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ValidationService validationService;


    @Override
    public AnswarDto create(AnswarDto answarDto){
        Answar answar = modelMapper.map(answarDto, Answar.class);
        //answar.setAnswareText(answarDto.getAnswareText());
        answar = answarRepository.save(answar);

        validationService.create(
                new ValidationDto(
                        null,
                        answarDto.getPoints(),
                        answarDto.getCheckAnswar(),
                        answarDto.getQuestion_id(),
                        answar.getId()
                )
        );

        return modelMapper.map(answar, AnswarDto.class);
    }
}