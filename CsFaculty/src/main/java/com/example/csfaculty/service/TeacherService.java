package com.example.csfaculty.service;

import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddTeacherServiceModel;

public interface TeacherService {
    Teacher findTeacherByFirstAndLastName(Long id, String teacherFirstName, String teacherLastName);

    void addTeacher(AddTeacherServiceModel addTeacherServiceModel);
}
