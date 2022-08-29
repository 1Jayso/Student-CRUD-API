package com.project.student.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();

    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{StudentId}")
    public void deleteStudent(@PathVariable("StudentId") Long s){
        studentService.removeStudent(s);
    }


    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.update(id, name , email);
    }

    @GetMapping(path = "{studentId}")
    public Student fetchAStudent(@PathVariable("studentId") Long id){
       return studentService.fetchAStudent(id);
    }

}
