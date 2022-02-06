package com.example.csfaculty.service.impl;

import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddSubjectServiceModel;
import com.example.csfaculty.repository.SubjectRepository;
import com.example.csfaculty.service.SubjectService;
import com.example.csfaculty.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public SubjectServiceImpl(SubjectRepository subjectRepository, TeacherService teacherService, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addSubject(Teacher teacher, AddSubjectServiceModel addSubjectServiceModel) {
        Subject newSubject = modelMapper.map(addSubjectServiceModel, Subject.class);
        newSubject.setLeadingTeacher(teacher);

        if (!subjectRepository.findByName(newSubject.getName()).isPresent()){
            subjectRepository.save(newSubject);
        }
    }

    @Override
    public Subject findSubjectByName(String subjectName) {
        return subjectRepository.findByName(subjectName).orElse(null);
    }

    @Override
    public Set<Subject> getAllSubjects() {
        return subjectRepository.findAllBy();
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getTopThreeSubjects() {
        return subjectRepository.getSubjectsOrderedBy().stream().limit(3).collect(Collectors.toList());
    }
}
