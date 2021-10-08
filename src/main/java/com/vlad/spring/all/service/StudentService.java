package com.vlad.spring.all.service;

import com.vlad.spring.all.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();

    public void saveStudent(Student student);

    public Student getStudent(int id);

    public void deleteStudent(int id);

}
