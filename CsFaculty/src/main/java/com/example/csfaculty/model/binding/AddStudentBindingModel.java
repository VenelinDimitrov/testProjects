package com.example.csfaculty.model.binding;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.NotBlank;

public class AddStudentBindingModel {

    private String firstName;
    private String lastName;
    private String course;

    public AddStudentBindingModel() {
    }

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotBlank
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
