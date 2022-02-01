package com.example.csfaculty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @GetMapping("/add")
    public String addSubject(){
        return "add-subject";
    }
}
