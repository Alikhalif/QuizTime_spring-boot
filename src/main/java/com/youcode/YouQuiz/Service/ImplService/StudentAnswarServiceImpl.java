package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.StudentAnswarService;
import com.youcode.YouQuiz.dto.StudentAnswar.StudentAnswarResponsDto;
import com.youcode.YouQuiz.dto.StudentAnswarDto;
import com.youcode.YouQuiz.entities.Answar;
import com.youcode.YouQuiz.entities.AssignQuiz;
import com.youcode.YouQuiz.entities.StudentAnswar;
import com.youcode.YouQuiz.entities.Validation;
import com.youcode.YouQuiz.repositories.AssignQuizRepository;
import com.youcode.YouQuiz.repositories.StudentAnswarRepository;
import com.youcode.YouQuiz.repositories.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentAnswarServiceImpl implements StudentAnswarService {

    @Autowired
    private StudentAnswarRepository studentAnswarRepository;

    @Autowired
    private ValidationRepository validationRepository;

    @Autowired
    private AssignQuizRepository assignQuizRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentAnswarDto create(StudentAnswarDto studentAnswarDto){
        StudentAnswar studentAnswar = modelMapper.map(studentAnswarDto, StudentAnswar.class);
        if (studentAnswarDto.getAssign_id() != null) {
            AssignQuiz assignQuiz = assignQuizRepository.findById(studentAnswarDto.getAssign_id())
                    .orElseThrow(() -> new EntityNotFoundException("The assignment with id " + studentAnswarDto.getAssign_id() + " is not found"));
            studentAnswar.setAssignQuiz(assignQuiz);
        }

        if (studentAnswarDto.getValidation_id() != null) {
            Validation validation = validationRepository.findById(studentAnswarDto.getValidation_id())
                    .orElseThrow(() -> new EntityNotFoundException("Validation with this id" + studentAnswarDto.getValidation_id() + " not found"));
            studentAnswar.setValidation(validation);
            studentAnswar.setScore(validation.getPoints());
        }
        if(studentAnswarRepository.countStudentAnswarByValidationIdAndAndAssignQuiz_Id(studentAnswarDto.getValidation_id(), studentAnswarDto.getAssign_id()) > 0)
            throw new EntityNotFoundException("answer exist");

        studentAnswar = studentAnswarRepository.save(studentAnswar);
        return modelMapper.map(studentAnswar, StudentAnswarDto.class);
    }


    @Override
    public List<StudentAnswarResponsDto> getAllAnswarOfStudent(Long assign_id){
        AssignQuiz assignQuiz = assignQuizRepository.findById(assign_id)
                .orElseThrow(() -> new EntityNotFoundException("assignment with id " + assign_id + " is not found"));
        List<Double> points = new ArrayList<>();
        List<String> ansmarsStudent = new ArrayList<>();
        List<Answar> answars = assignQuiz.getStudentAnswarList().stream()
                .map(studentAnswar -> {
                    points.add(studentAnswar.getValidation().getPoints());
                    ansmarsStudent.add(studentAnswar.getValidation().getAnswar().getAnswareText());
                     return studentAnswar.getValidation().getAnswar();
                }).toList();

        List<StudentAnswarResponsDto> studentAnswarList = Arrays.asList(modelMapper.map(answars, StudentAnswarResponsDto[].class));

        double resultFinal = 0;
        for (int i=0; i < points.size(); i++){
            resultFinal += points.get(i);
            StudentAnswarResponsDto studentAnswarResponsDto = studentAnswarList.get(i);
            studentAnswarResponsDto.setScore(points.get(i));
            studentAnswarResponsDto.setAnswarStudent(ansmarsStudent.get(i));
            studentAnswarResponsDto.setResultFinal(resultFinal);
            studentAnswarList.set(i, studentAnswarResponsDto);
        }
        return studentAnswarList;
    }

}
