package com.g2.appmiddleware.interfaces.rest;


import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.infrastructure.rest.CourseServiceClient;
import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.courseinstance.CourseOccasionResponse;
import com.g2.courseservice.api.rest.teacher.TeacherListResponse;
import com.g2.courseservice.api.rest.teacher.TeacherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceClient courseServiceClient;

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<List<CourseResponse>> getAllCourses(){
        return courseServiceClient.getAllCourses();
    }
    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.GET_COURSE)
    ResponseEntity<CourseResponse> findOneCourse(@PathVariable String courseCode){
        return courseServiceClient.findOneCourse(courseCode);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.GET_COURSE_INSTANCE)
    ResponseEntity<CourseOccasionResponse> findOneCourseOccasion(@PathVariable long courseOccasionId){
        return courseServiceClient.findOneCourseOccasion(courseOccasionId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.COURSE_OCCASIONS)
    ResponseEntity<List<CourseOccasionResponse>> findCourseOccasionsByCourseCode(
            @RequestParam(value = "course_code", required = false) String courseCode
    ){
        return courseServiceClient.findCourseOccasionsByCourseCode(courseCode);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest){
       return courseServiceClient.createCourse(courseRequest);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.GET_TEACHER)
    ResponseEntity<TeacherResponse> findOne(@PathVariable long teacherId){
        return courseServiceClient.findOne(teacherId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.TEACHER_RESOURCE)
    ResponseEntity<TeacherListResponse> getAll(){
        return courseServiceClient.getAll();
    }

}
