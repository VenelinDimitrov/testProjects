package com.example.csfaculty.service.impl;

import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddSubjectServiceModel;
import com.example.csfaculty.repository.SubjectRepository;
import com.example.csfaculty.service.SubjectService;
import com.example.csfaculty.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    public SubjectServiceImpl(SubjectRepository subjectRepository, TeacherService teacherService, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addSubject(AddSubjectServiceModel addSubjectServiceModel) {
        String[] teacherNames = addSubjectServiceModel.getLeadingTeacher().split("\\s+");
        String teacherFirstName = teacherNames[0];
        String teacherLastName = teacherNames[1];
        long teacherId = addSubjectServiceModel.getTeacherId();

        Teacher teacher = teacherService.findTeacherByFirstAndLastName(teacherId, teacherFirstName, teacherLastName);

        Subject newSubject = modelMapper.map(addSubjectServiceModel, Subject.class);
        newSubject.setLeadingTeacher(teacher);

        subjectRepository.save(newSubject);
    }
}