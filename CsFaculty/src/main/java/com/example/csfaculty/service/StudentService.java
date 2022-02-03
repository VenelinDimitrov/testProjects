package com.example.csfaculty.service;

import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.model.service.UpdateStudentSubjectsServiceModel;

public interface StudentService {

    void addStudent(AddStudentServiceModel addStudentServiceModel);

    void updateStudentSubjects(UpdateStudentSubjectsServiceModel updateStudentSubjectsServiceModel);
}
