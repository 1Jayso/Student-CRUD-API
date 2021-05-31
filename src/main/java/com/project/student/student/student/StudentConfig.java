package com.project.student.student.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1 = new Student(
                    "Gideon",
                    "gid@gmail.com",
                    LocalDate.of(2000, Month.JULY, 5)
            );



            Student student2 = new Student(
                    "Jacob",
                    "jycb@gmail.com",
                    LocalDate.of(1995, Month.JULY, 15)
            );


            Student student3 = new Student(
                    "Mary",
                    "mhary@gmail.com",
                    LocalDate.of(2002, Month.JULY, 5)
            );

            repository.saveAll(List.of(student1, student2, student3));

        };
    }
}
