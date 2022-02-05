package com.example.csfaculty.service.impl;

import com.example.csfaculty.model.entity.Student;
import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.model.service.UpdateStudentSubjectsServiceModel;
import com.example.csfaculty.repository.StudentRepository;
import com.example.csfaculty.service.StudentService;
import com.example.csfaculty.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final SubjectService subjectService;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper, SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.subjectService = subjectService;
    }

    @Override
    public void addStudent(AddStudentServiceModel addStudentServiceModel) {
        Student newStudent = modelMapper.map(addStudentServiceModel, Student.class);

        studentRepository.save(newStudent);
    }

    @Override
    public void updateStudentSubjects(UpdateStudentSubjectsServiceModel updateStudentSubjectsServiceModel) {
        String[] names = updateStudentSubjectsServiceModel.getStudentNames().split("\\s+");
        String firstName = names[0];
        String lastName = names[1];

        Student currentStudent = studentRepository.findByIdAndFirstNameAndLastName(updateStudentSubjectsServiceModel.getStudentId(),
                firstName, lastName).orElse(null);

        Subject subject = subjectService.findSubjectByName(updateStudentSubjectsServiceModel.getSubjectName());

        if (currentStudent != null && subject != null){

            if (updateStudentSubjectsServiceModel.getAction().equals("Add Subject")){
                currentStudent.getSubjectsTaken().add(subject);
            } else if (updateStudentSubjectsServiceModel.getAction().equals("Remove Subject")){
                Set<Subject> newSubjectList = currentStudent.getSubjectsTaken().stream().filter(s -> s.getId() != subject.getId())
                        .collect(Collectors.toSet());

                currentStudent.setSubjectsTaken(newSubjectList);
            }
        }

        studentRepository.save(currentStudent);
    }

    @Override
    public Set<Student> getAllStudents() {
        return studentRepository.findAllBy();
    }
}
