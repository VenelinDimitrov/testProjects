package com.example.csfaculty.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity{

    private String firstName;
    private String lastName;
    private String title;
    private Set<Subject> leadSubjects;

    public Teacher() {
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "leadingTeacher", fetch = FetchType.EAGER)
    public Set<Subject> getLeadSubjects() {
        return leadSubjects;
    }

    public void setLeadSubjects(Set<Subject> ledSubjects) {
        this.leadSubjects = ledSubjects;
    }
}
