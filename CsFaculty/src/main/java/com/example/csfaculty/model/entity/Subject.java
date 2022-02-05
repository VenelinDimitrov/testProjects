package com.example.csfaculty.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {

    private String name;
    private Teacher leadingTeacher;
    private int credits;
    private Set<Student> studentsTakingSubject;

    public Subject() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Teacher getLeadingTeacher() {
        return leadingTeacher;
    }

    public void setLeadingTeacher(Teacher leadingTeacher) {
        this.leadingTeacher = leadingTeacher;
    }

    @Column(nullable = false)
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Student> getStudentsTakingSubject() {
        return studentsTakingSubject;
    }

    public void setStudentsTakingSubject(Set<Student> studentsTakingSubject) {
        this.studentsTakingSubject = studentsTakingSubject;
    }
}
