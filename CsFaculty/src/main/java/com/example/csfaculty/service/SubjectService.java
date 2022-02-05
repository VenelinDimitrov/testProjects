package com.example.csfaculty.service;

import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.service.AddSubjectServiceModel;

import java.util.List;
import java.util.Set;

public interface SubjectService {
    void addSubject(AddSubjectServiceModel addSubjectServiceModel);

    Subject findSubjectByName(String subjectName);

    Set<Subject> getAllSubjects();

    void saveSubject(Subject subject);

    List<Subject> getTopThreeSubjects();
}
