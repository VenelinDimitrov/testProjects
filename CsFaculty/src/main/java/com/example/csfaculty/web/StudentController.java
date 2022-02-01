package com.example.csfaculty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/add")
    public String addStudent(){
        return "add-student";
    }

    @GetMapping("/administration")
    public String studentAdministration(){
        return "administration";
    }
}
