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
    public void updateStudentSubjects(Student currentStudent , UpdateStudentSubjectsServiceModel updateStudentSubjectsServiceModel) {


        Subject subject = subjectService.findSubjectByName(updateStudentSubjectsServiceModel.getSubjectName());

        if (subject != null){

            if (updateStudentSubjectsServiceModel.getAction().equals("Add Subject")){
                currentStudent.getSubjectsTaken().add(subject);
                subject.getStudentsTakingSubject().add(currentStudent);
            } else if (updateStudentSubjectsServiceModel.getAction().equals("Remove Subject")){
                Set<Subject> newSubjectList = currentStudent.getSubjectsTaken().stream().filter(s -> s.getId() != subject.getId())
                        .collect(Collectors.toSet());

                Set<Student> newStudentList = subject.getStudentsTakingSubject().stream().filter(s -> s.getId() != currentStudent.getId())
                        .collect(Collectors.toSet());

                currentStudent.setSubjectsTaken(newSubjectList);
                subject.setStudentsTakingSubject(newStudentList);
            }

            studentRepository.save(currentStudent);
            subjectService.saveSubject(subject);
        }
    }

    @Override
    public Set<Student> getAllStudents() {
        return studentRepository.findAllBy();
    }

    @Override
    public Student getStudent(Long studentId, String firstName, String lastName) {
        return studentRepository.findByIdAndFirstNameAndLastName(studentId, firstName,lastName).orElse(null);
    }
}
