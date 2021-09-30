package com.ruipeixoto.producingapi.bootstrap;

import com.ruipeixoto.producingapi.model.Student;
import com.ruipeixoto.producingapi.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;

public class BootstrapCommandLineRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BootstrapCommandLineRunner.class);
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student("Rui", "rp@gmail.com");
        student = studentRepository.save(student);
        logger.info("{} : Saved to DB : {}",LocalDateTime.now(),student);
        student = new Student("Joana", "jd@gmail.com");
        studentRepository.save(student);
        logger.info("{} : Saved to DB : {}",LocalDateTime.now(),student);

    }
}
