package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Exception.EntityNotFoundException;
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

    @Override
    public StudentDto create(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getOne(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(student -> modelMapper.map(student, StudentDto.class)).orElse(null);
    }


    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        if(studentRepository.existsById(id)){
            Student student = modelMapper.map(studentDto, Student.class);
            student.setId(id);
            student = studentRepository.save(student);
            return modelMapper.map(student, StudentDto.class);
        }else {
            try {
                throw new EntityNotFoundException("Student Not Found with id : "+ id);
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Long id){
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else {
            try {
                throw new EntityNotFoundException("Student not found with id : "+ id);
            } catch (EntityNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
