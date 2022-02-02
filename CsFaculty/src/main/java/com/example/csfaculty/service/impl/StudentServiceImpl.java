package com.example.csfaculty.service.impl;

import com.example.csfaculty.model.entity.Student;
import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.repository.StudentRepository;
import com.example.csfaculty.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addStudent(AddStudentServiceModel addStudentServiceModel) {
        Student newStudent = modelMapper.map(addStudentServiceModel, Student.class);

        studentRepository.save(newStudent);
    }
}
