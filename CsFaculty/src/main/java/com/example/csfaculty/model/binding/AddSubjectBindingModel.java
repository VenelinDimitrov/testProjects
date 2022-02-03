package com.example.csfaculty.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class AddSubjectBindingModel {

    private String subjectName;
    private String leadingTeacher;
    private Long teacherId;
    private int credits;

    public AddSubjectBindingModel() {
    }

    @NotBlank
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+) ([A-Z][a-z]+)",message = "Invalid Teacher Name") // TODO check if regex pattern is working correctly
    public String getLeadingTeacher() {
        return leadingTeacher;
    }

    public void setLeadingTeacher(String leadingTeacher) {
        this.leadingTeacher = leadingTeacher;
    }

    @Positive
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Positive
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
