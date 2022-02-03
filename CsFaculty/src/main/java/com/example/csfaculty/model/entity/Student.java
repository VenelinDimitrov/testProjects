package com.example.csfaculty.model.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends BaseEntity{

    private String firstName;
    private String lastName;
    private String course;
    private Set<Subject> subjectsTaken;

    public Student() {
        this.subjectsTaken = new LinkedHashSet<>();
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

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Subject> getSubjectsTaken() {
        return subjectsTaken;
    }

    public void setSubjectsTaken(Set<Subject> subjects) {
        this.subjectsTaken = subjects;
    }
}
