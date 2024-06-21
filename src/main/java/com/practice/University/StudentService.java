package com.practice.University;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
//    private final JdbcTemplate  jdbcTemplate;
    private  final JdbcTemplate jdbcTemplate;


    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    //operations
    //add Student
    public void addStudent(Student student) {
        String sql = "INSERT INTO student values (?,?,?)"; // placeholder
        jdbcTemplate.update(sql,  student.getId(),student.getName(), student.getPhone());

    }
    //get all students
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Student.class));
    }
    //get student by id
    public Student getStudentById(int id){
        String sql = "SELECT * FROM student where id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Student.class)
        );
    }
    //delete student
    public void deleteStudent(int id){
        String sql = "DELETE FROM student WHERE id = ?"; //placeholder
        jdbcTemplate.update(sql,id);

    }
    //update student
    public void updateStudent(Student student){
//        String sql = "UPDATE student SET name =? where id = ?";
        String sql = "UPDATE student SET name =?,phone =? where id =?"; //placeholder
       jdbcTemplate.update(sql, student.getId(), student.getName(), student.getPhone());
    }
}
