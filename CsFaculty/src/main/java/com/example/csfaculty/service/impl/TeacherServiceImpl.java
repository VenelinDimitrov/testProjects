package com.example.csfaculty.service.impl;

import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddTeacherServiceModel;
import com.example.csfaculty.repository.TeacherRepository;
import com.example.csfaculty.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Teacher findTeacherByFirstAndLastName(Long id, String firstName, String lastName) {
        return teacherRepository.findByIdAndFirstNameAndLastName(id, firstName, lastName).orElse(null);
    }

    @Override
    public void addTeacher(AddTeacherServiceModel addTeacherServiceModel) {
        Teacher newTeacher = modelMapper.map(addTeacherServiceModel, Teacher.class);

        teacherRepository.save(newTeacher);
    }

    @Override
    public Set<Teacher> getAllTeachers() {
        return teacherRepository.findAllBy();
    }

    @Override
    public List<Teacher> getTopThreeTeachers() {
        List<Teacher> orderedListOfTeachers = teacherRepository.getTopThreeTeachers();
        Collections.reverse(orderedListOfTeachers);

        return orderedListOfTeachers.stream().limit(3).collect(Collectors.toList());
    }
}
