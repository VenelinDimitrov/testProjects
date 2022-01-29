package com.example.csfaculty.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends BaseEntity{

    private String firstName;
    private String lastName;
    private String course;
    private List<Subject> subjectsTaken;

    public Student() {
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @ManyToMany
    public List<Subject> getSubjectsTaken() {
        return subjectsTaken;
    }

    public void setSubjectsTaken(List<Subject> subjects) {
        this.subjectsTaken = subjects;
    }
}
