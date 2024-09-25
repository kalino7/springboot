package com.example.demo7.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    
    private final StudentService studentService;

    // studentservice is already instantiated due to @service component specified in the class
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @GetMapping
    public List<Student> getStuds(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addStuds(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping(path="{studentId}")
    public void updateStuds(@PathVariable Long studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStud(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    
}
