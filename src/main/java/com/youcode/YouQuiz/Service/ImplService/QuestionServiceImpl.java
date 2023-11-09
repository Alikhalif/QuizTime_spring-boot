package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.QuestionService;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.entities.Level;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Subject;
import com.youcode.YouQuiz.repositories.LevelRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public QuestionDto create(QuestionDto questionDto){
        Question question = modelMapper.map(questionDto, Question.class);

        if(questionDto.getLevelId() != null){
            Level level = levelRepository.findById(questionDto.getLevelId())
                    .orElseThrow(() -> new EntityNotFoundException("Level not found"));
            question.setLevel(level);
        }

        if(questionDto.getSubjectId() != null){
            Subject subject = subjectRepository.findById(questionDto.getSubjectId())
                    .orElseThrow(()-> new EntityNotFoundException("Subject not found"));
            question.setSubject(subject);
        }

        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDto.class);
    }


    @Override
    public void delete(Long id){
        Question question = questionRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        questionRepository.delete(question);
    }

    @Override
    public QuestionDto getOne(Long id){
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id "+id));
        return modelMapper.map(question, QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAll(){
        return Arrays.asList(modelMapper.map(questionRepository.findAll(), QuestionDto[].class));
    }

}
