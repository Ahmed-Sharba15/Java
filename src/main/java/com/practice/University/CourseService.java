package com.practice.University;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final JdbcTemplate jdbcTemplate;

    public CourseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public  void  addCustomer(Courses courses){
        String sql = "INSERT INTO courses Values(? , ?, ?)";
        jdbcTemplate.update(sql,courses.getId(), courses.getName(), courses.getMarks());
    }

    //select all courses
    public List<Courses> getAllCustomers(){
        String sql = "SELECT * FROM courses";
        return   jdbcTemplate.query(sql ,
                new BeanPropertyRowMapper<>(Courses.class));
    }

    //select courses by id
    public Courses getCustomerById(int id){
        String sql = "SELECT * FROM courses where id = ?";
        try {
            return   jdbcTemplate.queryForObject(sql ,
                    new Object[]{id},
                    new BeanPropertyRowMapper<>(Courses.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
    //delete courses
    public void deleteCustomer(int id){
        String sql = "DELETE FROM courses WHERE id = ?";
        jdbcTemplate.update(sql , id);
    }

    //update customer
    public void updateCourses(Courses Course){
        String sql = "UPDATE courses SET name = ? where id =?";
        jdbcTemplate.update(sql ,Course.getId(),Course.getName(),Course.getMarks());
    }
}
