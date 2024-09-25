package com.example.demo7.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student noelle = new Student("noelle", LocalDate.of(1997, Month.DECEMBER, 24) , "noelle@gmail.com");

            Student james = new Student("james", LocalDate.of(2000, Month.DECEMBER, 24) , "james@gmail.com");

            repository.saveAll(
                List.of(noelle, james)
            );
        };
    }
}
