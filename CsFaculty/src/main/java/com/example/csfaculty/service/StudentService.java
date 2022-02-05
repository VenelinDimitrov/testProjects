package com.example.csfaculty.service;

import com.example.csfaculty.model.entity.Student;
import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.model.service.UpdateStudentSubjectsServiceModel;

import java.util.Set;

public interface StudentService {

    void addStudent(AddStudentServiceModel addStudentServiceModel);

    void updateStudentSubjects(UpdateStudentSubjectsServiceModel updateStudentSubjectsServiceModel);

    Set<Student> getAllStudents();
}
