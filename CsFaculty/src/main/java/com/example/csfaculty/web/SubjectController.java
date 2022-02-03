package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddSubjectBindingModel;
import com.example.csfaculty.model.service.AddSubjectServiceModel;
import com.example.csfaculty.service.SubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final ModelMapper modelMapper;

    public SubjectController(SubjectService subjectService, ModelMapper modelMapper) {
        this.subjectService = subjectService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addSubject(){
        return "add-subject";
    }

    @PostMapping("/add")
    public String addStudentConfirm(@Valid AddSubjectBindingModel addSubjectBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addSubjectBindingModel", addSubjectBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSubjectBindingModel", bindingResult);

            return "redirect:add";
        }

        subjectService.addSubject(modelMapper.map(addSubjectBindingModel, AddSubjectServiceModel.class));

        return "redirect:add";
    }

    @ModelAttribute
    public AddSubjectBindingModel addSubjectBindingModel(){
        return new AddSubjectBindingModel();
    }
}
