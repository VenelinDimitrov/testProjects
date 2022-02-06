package com.example.csfaculty.repository;

import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByIdAndFirstNameAndLastName(Long id, String firstName, String lastName);

    @Query("SELECT t from Teacher t ORDER BY t.firstName, t.lastName")
    Set<Teacher> findAllBy();

    @Query("SELECT t FROM Teacher t JOIN Subject sub ON t.id = sub.leadingTeacher.id" +
            " GROUP BY t.id ORDER BY (size(sub.studentsTakingSubject))")
    List<Teacher> getTopThreeTeachers();
}
