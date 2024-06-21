package com.practice.University;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/all")
    public List<Student> getStudents(){
       return studentService.getAllStudents();
    }

   @GetMapping("/{id}")
   public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);

   }


    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id,
                               @RequestBody Student student){
        student.setId(id);
        studentService.updateStudent(student);
    }

}
