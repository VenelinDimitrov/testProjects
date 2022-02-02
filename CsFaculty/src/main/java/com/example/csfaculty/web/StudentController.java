package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddStudentBindingModel;
import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    public StudentController(StudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addStudent(){
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudentConfirm(@Valid AddStudentBindingModel addStudentBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addStudentBindingModel", addStudentBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addStudentBindingModel", bindingResult);

            return "redirect:add";
        }

        studentService.addStudent(modelMapper.map(addStudentBindingModel, AddStudentServiceModel.class));

        return "redirect:add";
    }

    @GetMapping("/administration")
    public String studentAdministration(){
        return "administration";
    }


    @ModelAttribute
    public AddStudentBindingModel addStudentBindingModel(){
        return new AddStudentBindingModel();
    }
}
