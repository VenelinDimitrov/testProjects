package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddTeacherBindingModel;
import com.example.csfaculty.model.service.AddTeacherServiceModel;
import com.example.csfaculty.service.TeacherService;
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
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    public TeacherController(TeacherService teacherService, ModelMapper modelMapper) {
        this.teacherService = teacherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addTeacher(){
        return "add-teacher";
    }

    @PostMapping("/add")
    public String addTeacherConfirm(@Valid AddTeacherBindingModel addTeacherBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addTeacherBindingModel", addTeacherBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTeacherBindingModel", bindingResult);

            return "redirect:add";
        }

        teacherService.addTeacher(modelMapper.map(addTeacherBindingModel, AddTeacherServiceModel.class));

        return "redirect:add";
    }

    @ModelAttribute
    public AddTeacherBindingModel addTeacherBindingModel(){
        return new AddTeacherBindingModel();
    }
}
