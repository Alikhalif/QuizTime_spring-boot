package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.StudentService;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<StudentDto> getAll(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    public StudentDto getOne(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(student -> modelMapper.map(student, StudentDto.class)).orElse(null);
    }
}
