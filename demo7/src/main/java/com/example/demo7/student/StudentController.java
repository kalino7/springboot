package com.example.demo7.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    
    private final StudentService studentService;

    // studentservice is already instantiated due to @service component specified in the class
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping
    public List<Student> getStud(){
        return studentService.getStudents();
    }
    
}
