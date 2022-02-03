package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddStudentBindingModel;
import com.example.csfaculty.model.binding.UpdateStudentSubjectsBindingModel;
import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.service.AddStudentServiceModel;
import com.example.csfaculty.model.service.UpdateStudentSubjectsServiceModel;
import com.example.csfaculty.service.StudentService;
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
import java.util.Set;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;
    private final SubjectService subjectService;

    public StudentController(StudentService studentService, ModelMapper modelMapper, SubjectService subjectService) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
        this.subjectService = subjectService;
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
    public String studentAdministration(Model model){
        Set<Subject> allSubjects = subjectService.getAllSubjects();
        model.addAttribute("allSubjects", allSubjects);

        return "administration";
    }

    @PostMapping("/update")
    public String updateSubjectList(@Valid UpdateStudentSubjectsBindingModel updateStudentSubjectsBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("updateStudentSubjectsBindingModel", updateStudentSubjectsBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateStudentSubjectsBindingModel", bindingResult);

            return "redirect:administration";
        }

        studentService.updateStudentSubjects(modelMapper.map(updateStudentSubjectsBindingModel, UpdateStudentSubjectsServiceModel.class));

        return "redirect:administration";
    }


    @ModelAttribute
    public AddStudentBindingModel addStudentBindingModel(){
        return new AddStudentBindingModel();
    }

    @ModelAttribute
    public UpdateStudentSubjectsBindingModel updateStudentSubjectsBindingModel(){
        return new UpdateStudentSubjectsBindingModel();
    }
}
