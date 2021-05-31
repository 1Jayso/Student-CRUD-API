package com.project.student.student.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    Fetch all students from the Database
    public List<Student> getStudent(){
        return studentRepository.findAll();

    }

//    Add a new student to the Database
    public void addNewStudent(Student student) {
        Optional <Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentEmail.isPresent()){
            throw new IllegalStateException("email already taken, try a different one!");
        }
        studentRepository.save(student);


        System.out.println(student);
    }

//Delete a student record from the Database
    public void removeStudent(Long id) {
        boolean studentExist = studentRepository.existsById(id);
        if(!studentExist){
            throw new IllegalStateException("Student with ID "+ id + " does not exist in Database");
        }

        studentRepository.deleteById(id);
        System.out.println("Student has been deleted successfully ");

    }
//    Check if a student exists and update a student
    @Transactional
    public void update(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow( () -> new IllegalStateException(
                "Student with ID " + id +" does not exist inn the database"
        ));

        if(name != null && name.length() > 0 && !student.getName().equals(name)) {
            student.setName(name);
        }

        if(email !=null && email.length() > 0 && !student.getEmail().equals(email)){

            Optional <Student> studentEmail = studentRepository.findStudentByEmail(email);
            if (studentEmail.isPresent()){
                throw new IllegalStateException("Email is already taken");
            }
            student.setEmail(email);
        }

    }

//    Fetch a student by ID from the database
    public Student fetchAStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Student with ID " + id + " does not exist in the database"
        ));

        return student;
    }

}
