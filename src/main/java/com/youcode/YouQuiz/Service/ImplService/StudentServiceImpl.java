package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.StudentService;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StudentDto create(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

}
