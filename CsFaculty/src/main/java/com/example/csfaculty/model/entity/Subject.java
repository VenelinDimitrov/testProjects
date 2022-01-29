package com.example.csfaculty.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {

    private String name;
    private Teacher leadingTeacher;
    private int credits;

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
}
