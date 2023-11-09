package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.SubjectService;
import com.youcode.YouQuiz.dto.SubjectDto;
import com.youcode.YouQuiz.entities.Subject;
import com.youcode.YouQuiz.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectDto create(SubjectDto subjectDto){
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        if(subjectDto.getParentId() != null){
            Subject subjectParent = subjectRepository.findById(subjectDto.getParentId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent subject not found"));
            subject.setParent(subjectParent);
        }
        subject = subjectRepository.save(subject);
        return modelMapper.map(subject, SubjectDto.class);
    }


    @Override
    public void delete(Long id){
        Subject subject = subjectRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Subject not found with id "+id));
        subjectRepository.delete(subject);
    }

    @Override
    public SubjectDto getOne(Long id){
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Subject not found with id "+id));
        return modelMapper.map(subject, SubjectDto.class);
    }

}
