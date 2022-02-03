package com.example.csfaculty.model.binding;

import javax.validation.constraints.NotBlank;

public class AddTeacherBindingModel {

    private String firstName;
    private String lastName;
    private String title;

    public AddTeacherBindingModel() {
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
