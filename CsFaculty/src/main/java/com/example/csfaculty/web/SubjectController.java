package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddSubjectBindingModel;
import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddSubjectServiceModel;
import com.example.csfaculty.service.SubjectService;
import com.example.csfaculty.service.TeacherService;
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

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final ModelMapper modelMapper;
    private final TeacherService teacherService;

    public SubjectController(SubjectService subjectService, ModelMapper modelMapper, TeacherService teacherService) {
        this.subjectService = subjectService;
        this.modelMapper = modelMapper;
        this.teacherService = teacherService;
    }

    @GetMapping("/add")
    public String addSubject(Model model){
        if (!model.containsAttribute("isFound")){
            model.addAttribute("isFound", true);
        }

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

        String[] teacherNames = addSubjectBindingModel.getLeadingTeacher().split("\\s+");
        String teacherFirstName = teacherNames[0];
        String teacherLastName = teacherNames[1];
        long teacherId = addSubjectBindingModel.getTeacherId();

        Teacher teacher = teacherService.findTeacherByFirstAndLastName(teacherId, teacherFirstName, teacherLastName);

        if (teacher == null) {
            redirectAttributes.addFlashAttribute("addSubjectBindingModel", addSubjectBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:add";
        }

        subjectService.addSubject(teacher, modelMapper.map(addSubjectBindingModel, AddSubjectServiceModel.class));

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
