package com.example.csfaculty.model.service;

public class UpdateStudentSubjectsServiceModel {

    private String subjectName;
    private String action;

    public UpdateStudentSubjectsServiceModel() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
