package com.example.csfaculty.repository;

import com.example.csfaculty.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndFirstNameAndLastName(Long id, String firstName, String lastName);
}
