package com.example.demo7.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email already exist!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists)
        {
            throw new IllegalStateException("ID: "+studentId+" does not exist");
        }

        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        
        // check if Id exists
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("ID not exist"));

        if(name!= null && !name.equals(student.getName()) ){
            student.setName(name);
        }

        if(email!=null && !email.equals(student.getEmail()))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("Email already taken");
            }

            student.setEmail(email);
        }
    }
}
