package com.practice.University;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService CourseService;

    public CourseController(com.practice.University.CourseService courseService) {
        CourseService = courseService;
    }


    //requests
    @PostMapping
    public void addCourse(@RequestBody Courses Courses){
        CourseService.addCustomer(Courses);
    }
    @GetMapping("/all")
    public List<Courses> getCourses(){
        return  CourseService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Courses getCourseById(@PathVariable int id){
        return CourseService.getCustomerById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable int id){
        CourseService.deleteCustomer(id);
    }

    @PutMapping("{id}")
    public void updateCoursesById(@PathVariable int id ,
                                   @RequestBody Courses Courses){
        Courses.setId(id);
        CourseService.updateCourses(Courses);
    }
}
