package com.example.demo7.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    //performs the DB query to check email exists. it returns true if present or false if absent
    Optional<Student> findStudentByEmail(String email);
}
