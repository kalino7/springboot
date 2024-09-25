package com.example.demo7.student;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName =  "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private Long id;
    private String name;
    private int age;
    private LocalDate dob;
    private String email;


    // constructors
    public Student()
    {

    }

    public Student(Long id, String name, int age, LocalDate dob, String email)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    // constructor without iD for DB generated ids
    public Student(String name, int age, LocalDate dob, String email)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Student{" + 
                  "id=" + id +
                  ", name=" + name +
                  ", email=" + email +
                  ", dob=" + dob + 
                  ", age=" + age +
                "}";
    }

}
