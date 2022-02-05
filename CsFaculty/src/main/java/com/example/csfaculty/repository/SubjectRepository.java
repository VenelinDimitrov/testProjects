package com.example.csfaculty.repository;

import com.example.csfaculty.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByName(String name);

    Set<Subject> findAllBy();

    @Query("SELECT s FROM Subject s ORDER BY size(s.studentsTakingSubject) DESC")
    List<Subject> getSubjectsOrderedBy();
}
