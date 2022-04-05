package com.example.csfaculty.web;

import com.example.csfaculty.model.binding.AddTeacherBindingModel;
import com.example.csfaculty.model.entity.Subject;
import com.example.csfaculty.model.entity.Teacher;
import com.example.csfaculty.model.service.AddTeacherServiceModel;
import com.example.csfaculty.service.StudentService;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final ModelMapper modelMapper;

    public TeacherController(TeacherService teacherService, ModelMapper modelMapper, StudentService studentService, SubjectService subjectService) {
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

    @GetMapping("/overview")
    public String teachersOverview(Model model){
        Set<Teacher> allTeachers = teacherService.getAllTeachers();

        model.addAttribute("allTeachers", allTeachers);

        return "teachers-overview";
    }

    @GetMapping("/top")
    public String getTopTeachers(Model model){
        List<Teacher> topThreeTeachersList = teacherService.getTopThreeTeachers();
        Map<Teacher, Integer> topThreeTeachers = new LinkedHashMap<>();

        for (int i = 0; i < topThreeTeachersList.size(); i++) {
            int studentsTakingTeachersSubjects = topThreeTeachersList.get(i).getLeadSubjects().stream()
                    .mapToInt(s -> s.getStudentsTakingSubject().size()).sum();

            topThreeTeachers.put(topThreeTeachersList.get(i), studentsTakingTeachersSubjects);
        }

        model.addAttribute("topThreeTeachers", topThreeTeachers);

        return "top-three-teachers";
    }

    @ModelAttribute
    public AddTeacherBindingModel addTeacherBindingModel(){
        return new AddTeacherBindingModel();
    }
}
