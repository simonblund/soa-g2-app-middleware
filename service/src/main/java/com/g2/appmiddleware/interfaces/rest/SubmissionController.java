package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.api.rest.submission.SubmissionCollectionResponse;
import com.g2.appmiddleware.api.rest.submission.SubmissionResponse;
import com.g2.appmiddleware.api.rest.submission.SubmissionVerificationRequest;
import com.g2.appmiddleware.application.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SubmissionController {
    private final SubmissionService service;

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.EXAMINATION)
    public ResponseEntity<SubmissionCollectionResponse> getSubmissionsForExamination(@PathVariable String examinationCode) {
        log.info("Endpoint {} hit with GET for {}", UrlPaths.EXAMINATION, examinationCode);
        return ResponseEntity.ok(service.getSubmissionsForExam(examinationCode));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(UrlPaths.SUBMISSION_VERIFY)
    public ResponseEntity<Void> verify(SubmissionVerificationRequest request){
        log.info("Endpoint {} hit with POST for {}", UrlPaths.SUBMISSION_VERIFY, request.getSubmissionId());
        try {
            service.verify(request.getSubmissionId());
            return ResponseEntity.ok(null);
        }catch (Exception e){
            throw e;
        }
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





     */
}
