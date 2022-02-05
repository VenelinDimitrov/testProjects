package com.example.csfaculty.web;

import com.example.csfaculty.model.entity.Student;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.service.StudentService;
import com.example.csfaculty.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    public HomeController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        Set<Teacher> allTeachers = teacherService.getAllTeachers();
        Set<Student> allStudents = studentService.getAllStudents();

        model.addAttribute("allTeachers", allTeachers);
        model.addAttribute("allStudents", allStudents);

        return "index";
    }
}
