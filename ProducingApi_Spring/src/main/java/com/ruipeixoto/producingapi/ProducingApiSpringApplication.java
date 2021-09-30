package com.ruipeixoto.producingapi;

import com.ruipeixoto.producingapi.model.Student;
import com.ruipeixoto.producingapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducingApiSpringApplication {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProducingApiSpringApplication.class, args);
    }


    @Bean
    public CommandLineRunner bootstrap(){
        return args -> {
            Student student = new Student("Rui", "rp@gmail.com");
            studentRepository.save(student);
            student = new Student("Joana", "jd@gmail.com");
            studentRepository.save(student);
        };
    }
}
