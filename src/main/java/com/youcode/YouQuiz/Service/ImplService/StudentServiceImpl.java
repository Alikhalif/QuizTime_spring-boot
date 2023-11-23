package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
import com.youcode.YouQuiz.Service.StudentService;
import com.youcode.YouQuiz.dto.StudentDto;
import com.youcode.YouQuiz.entities.Level;
import com.youcode.YouQuiz.entities.Student;
import com.youcode.YouQuiz.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto create(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll(){
        return Arrays.asList(modelMapper.map(studentRepository.findAll(), StudentDto[].class));

    }

    @Override
    public StudentDto getOne(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(student -> modelMapper.map(student, StudentDto.class)).orElse(null);
    }


    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("The student with id " + id + " is not found"));
        Student student = modelMapper.map(studentDto, Student.class);
        student.setId(existingStudent.getId());
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public void delete(Long id){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("The student with id " + id + " is not found"));
        studentRepository.delete(existingStudent);
    }

    @Override
    public List<StudentDto> findByLimit(int pageNbr){
        Pageable page = PageRequest.of(pageNbr-1, 10);
        Page<Student> students = studentRepository.findAll(page);
        return Arrays.asList(modelMapper.map(students.toList(), StudentDto[].class));
    }
}
