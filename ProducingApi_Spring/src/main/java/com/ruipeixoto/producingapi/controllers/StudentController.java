package com.ruipeixoto.producingapi.controllers;

import com.ruipeixoto.producingapi.model.Student;
import com.ruipeixoto.producingapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public Iterable<Student> getAllStudent(){
        return studentRepository.findAll();
    }
}
