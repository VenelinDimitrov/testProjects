package com.example.csfaculty.model.service;

public class AddSubjectServiceModel {

    private String subjectName;
    private int credits;

    public AddSubjectServiceModel() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
