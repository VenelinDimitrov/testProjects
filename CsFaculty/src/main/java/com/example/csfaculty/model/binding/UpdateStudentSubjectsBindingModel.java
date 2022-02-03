package com.example.csfaculty.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class UpdateStudentSubjectsBindingModel {

    private Long studentId;
    private String studentNames;
    private String subjectName;
    private String action;

    public UpdateStudentSubjectsBindingModel() {
    }

    @Positive
    @NotNull
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+) ([A-Z][a-z]+)")
    public String getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentNames) {
        this.studentNames = studentNames;
    }

    @NotBlank
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @NotBlank
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
