package com.g2.appmiddleware.application;

import com.g2.appmiddleware.api.rest.submission.SubmissionCollectionResponse;

public interface SubmissionService {

    SubmissionCollectionResponse getSubmissionsForExam(String examinationCode);
    void verify(String submissionId);

   /*
   CourseCollectionResponse getAllCourses();
   Submission create(SubmissionRequest request);
    List<Submission> getAll();
  Submission verify(String submissionId);
  Submission getOne(String submissionId);
    */
}
