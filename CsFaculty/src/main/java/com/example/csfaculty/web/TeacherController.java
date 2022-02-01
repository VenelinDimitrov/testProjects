package com.example.csfaculty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @GetMapping("/add")
    public String addTeacher(){
        return "add-teacher";
    }
}
