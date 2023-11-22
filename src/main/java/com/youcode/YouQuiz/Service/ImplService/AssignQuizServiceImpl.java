package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.AssignQuizService;
import com.youcode.YouQuiz.dto.AssignQuizDto;
import com.youcode.YouQuiz.entities.AssignQuiz;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.AssignQuizRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.QuizRepository;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignQuizServiceImpl implements AssignQuizService {
    @Autowired
    private AssignQuizRepository assignQuizRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AssignQuizDto> create(List<AssignQuizDto> assignQuizDtos){
        return assignQuizDtos.stream()
                .map(assignQuizDto -> {
                    AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);

                    if (assignQuizDto.getStudent_id() != null){
                        Student student = studentRepository.findById(assignQuizDto.getStudent_id())
                                .orElseThrow(() -> new EntityNotFoundException("student not found with id: "+assignQuizDto.getStudent_id()));
                        assignQuiz.setStudent(student);
                    }

                    if (assignQuizDto.getQuiz_id() != null){
                        Quiz quiz = quizRepository.findById(assignQuizDto.getQuiz_id())
                                .orElseThrow(() -> new EntityNotFoundException("quiz not found with id: "+assignQuizDto.getQuiz_id()));
                        assignQuiz.setQuiz(quiz);
                    }

                    return assignQuizRepository.save(assignQuiz);
                })
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {
        AssignQuiz assignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The assignment with id " + id + " is not found"));
        assignQuizRepository.deleteById(id);
    }

    @Override
    public List<AssignQuizDto> getAll(){
        List<AssignQuiz> assignQuizs = assignQuizRepository.findAll();
        return assignQuizs.stream()
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDto.class))
                .toList();
    }

    @Override
    public AssignQuizDto getOne(Long id){
        AssignQuiz assignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The assignment with id " + id + " is not found"));
        return modelMapper.map(assignQuiz, AssignQuizDto.class);
    }

    @Override
    public AssignQuizDto update(Long id, AssignQuizDto assignQuizDto){
        AssignQuiz existingAssignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The assignment with id " + id + " is not found"));
        existingAssignQuiz.setReason(assignQuizDto.getReason());
        existingAssignQuiz.setResult(assignQuizDto.getResult());
        existingAssignQuiz.setDebutDate(assignQuizDto.getDebutDate());
        existingAssignQuiz.setEndDate(assignQuizDto.getEndDate());


        if (assignQuizDto.getQuiz_id() != null) {
            Quiz quiz = quizRepository.findById(assignQuizDto.getQuiz_id())
                    .orElseThrow(() -> new EntityNotFoundException("The quiz with id " + assignQuizDto.getQuiz_id() + " is not found"));
            existingAssignQuiz.setQuiz(quiz);
        }

        if (assignQuizDto.getStudent_id() != null) {
            Student student = studentRepository.findById(assignQuizDto.getStudent_id())
                    .orElseThrow(() -> new EntityNotFoundException("The student with id " + assignQuizDto.getStudent_id() + " is not found"));
            existingAssignQuiz.setStudent(student);
        }
        existingAssignQuiz = assignQuizRepository.save(existingAssignQuiz);
        return modelMapper.map(existingAssignQuiz, AssignQuizDto.class);
    }
}
