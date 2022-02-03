package com.example.csfaculty.model.service;

public class AddSubjectServiceModel {

    private String subjectName;
    private String leadingTeacher;
    private Long teacherId;
    private int credits;

    public AddSubjectServiceModel() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getLeadingTeacher() {
        return leadingTeacher;
    }

    public void setLeadingTeacher(String leadingTeacher) {
        this.leadingTeacher = leadingTeacher;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
