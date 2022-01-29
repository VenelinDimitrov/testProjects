package com.example.csfaculty.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity{

    private String firstName;
    private String lastName;
    private String title;
    private List<Subject> ledSubjects;

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

    @OneToMany(mappedBy = "leadingTeacher")
    public List<Subject> getLedSubjects() {
        return ledSubjects;
    }

    public void setLedSubjects(List<Subject> ledSubjects) {
        this.ledSubjects = ledSubjects;
    }
}
