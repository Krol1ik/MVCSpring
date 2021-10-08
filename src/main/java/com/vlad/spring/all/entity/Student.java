package com.vlad.spring.all.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "First_name")
    private String firstName;
    @Column (name = "Last_name")
    private String lastName;
    @Column (name = "Email")
    private String email;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Student info:" +
                "\nID =" + id +
                "\nFirstName = " + firstName +
                "\nLastName = " + lastName +
                "\nEmail = " + email;
    }
}
