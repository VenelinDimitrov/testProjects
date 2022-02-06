package com.example.csfaculty.repository;

import com.example.csfaculty.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndFirstNameAndLastName(Long id, String firstName, String lastName);

    @Query("SELECT s from Student s ORDER BY s.firstName, s.lastName")
    Set<Student> findAllBy();
}
