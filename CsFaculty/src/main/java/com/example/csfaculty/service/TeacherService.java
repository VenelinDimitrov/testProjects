package com.example.csfaculty.service;

import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddTeacherServiceModel;

import java.util.Set;

public interface TeacherService {
    Teacher findTeacherByFirstAndLastName(Long id, String teacherFirstName, String teacherLastName);

    void addTeacher(AddTeacherServiceModel addTeacherServiceModel);

    Set<Teacher> getAllTeachers();
}
