package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.api.rest.submission.SubmissionCollectionResponse;
import com.g2.appmiddleware.application.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService service;

    @GetMapping(UrlPaths.EXAMINATION)
    public ResponseEntity<SubmissionCollectionResponse> getSubmissionsForExamination(@PathVariable String examinationCode) {
        return ResponseEntity.ok(service.getSubmissionsForExam(examinationCode));
    }
/*
    @GetMapping(UrlPaths.COURSE_RESOURCE)
    public ResponseEntity<CourseCollectionResponse> getAllCourses(){
        try {
            val courses = service.getAllCourses();
            return ResponseEntity.ok(CourseCollectionResponse.builder().courses(courses).build());

        }catch (Exception e){
            throw e;
        }
    }


    @PostMapping(UrlPaths.SUBMISSION_RESOURCE)
    public ResponseEntity<Void> create(SubmissionRequest request){

        try {
            val submission = service.create(request);
            return ResponseEntity.status(200).build();
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping(UrlPaths.SUBMISSION_VERIFY)
    public ResponseEntity<SubmissionResponse> verify(SubmissionVerificationRequest request){

        try {
            val submission = service.verify(request.getSubmissionId());
            return ResponseEntity.ok(DomainObjectMapper.toSubmissionResponse(submission));
        }catch (Exception e){
            throw e;
        }
    }


     */
}
