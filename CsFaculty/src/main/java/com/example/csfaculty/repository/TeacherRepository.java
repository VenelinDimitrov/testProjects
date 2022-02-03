package com.example.csfaculty.repository;

import com.example.csfaculty.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByIdAndFirstNameAndLastName(Long id, String firstName, String lastName);
}
