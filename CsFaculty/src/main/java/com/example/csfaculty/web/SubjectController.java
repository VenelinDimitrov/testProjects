package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddSubjectBindingModel;
import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.service.AddSubjectServiceModel;
import com.example.csfaculty.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping("/top")
    public String getTopSubjects(Model model){

        List<Subject> topThreeSubjects = new ArrayList<>(subjectService.getTopThreeSubjects());

        model.addAttribute("topThreeSubjects", topThreeSubjects);

        return "top-three-subjects";
    }

    @ModelAttribute
    public AddSubjectBindingModel addSubjectBindingModel(){
        return new AddSubjectBindingModel();
    }
}
