package com.vlad.spring.all.controller;

import com.vlad.spring.all.entity.Student;
import com.vlad.spring.all.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Student student = new Student();
        theModel.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveCustomer(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("studentId") int studentId,
                                    Model theModel) {
        Student student = studentService.getStudent(studentId);
        theModel.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/student/list";
    }
}