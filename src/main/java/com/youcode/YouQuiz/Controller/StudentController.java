package com.youcode.YouQuiz.Controller;

import com.youcode.YouQuiz.Service.ImplService.StudentServiceImpl;
import com.youcode.YouQuiz.Service.StudentService;
import com.youcode.YouQuiz.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto studentCreated = studentService.create(studentDto);
        return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAll();
    }
}
