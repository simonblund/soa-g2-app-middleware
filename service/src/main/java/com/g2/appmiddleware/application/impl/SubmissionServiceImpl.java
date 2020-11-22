package com.g2.appmiddleware.application.impl;

import com.g2.appmiddleware.api.rest.submission.Grade;
import com.g2.appmiddleware.api.rest.submission.SubmissionCollectionResponse;
import com.g2.appmiddleware.api.rest.submission.SubmissionResponse;
import com.g2.appmiddleware.application.SubmissionService;
import com.g2.appmiddleware.infrastructure.rest.ESSubmissionClient;
import com.g2.appmiddleware.infrastructure.rest.StudentServiceClient;
import com.g2.examinationservice.api.rest.submission.SubmissionVerificationRequest;
import com.g2.studentservice.api.rest.StudentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {
    private final ESSubmissionClient submissionClient;
    private final StudentServiceClient studentServiceClient;

    public com.g2.appmiddleware.api.rest.submission.SubmissionCollectionResponse getSubmissionsForExam(String examinationCode){

        List<SubmissionResponse> submissions = new ArrayList<>();

        submissionClient.getSubmissionsForExamination(examinationCode).getBody()
                .getSubmissions().stream()
                .forEach(it -> {
                    val student = getStudent(it.getStudentId());
                    submissions.add(SubmissionResponse.builder()
                            .firstName(student.getFirstName())
                            .lastName(student.getLastname())
                            .studentId(it.getStudentId())
                            .moduleCode(it.getModuleCode())
                            .submissionId(it.getSubmissionId())
                            .grade(Grade.valueOf(it.getGrade().name()))
                            .build());
                });
        return SubmissionCollectionResponse.builder().submissions(submissions).build();
    }

    public void verify(String submissionId){

        submissionClient.verify(SubmissionVerificationRequest.builder().submissionId(submissionId).build());
    }

    private StudentResponse getStudent(String studentUser){
        return studentServiceClient.getStudent(studentUser).getBody();
    }

    /*


    public Submission create(SubmissionRequest request) {
        if (isDbEnabled) {
            val submission = Submission.builder()
                    .examination(examinationService.getExamination(request.getModuleCode()))
                    .grade(request.getGrade())
                    .studentId(request.getStudentId())
                    .teacherId(request.getTeacherId())
                    .build();

            return repository.save(submission);

        } else {
            log.error("Submission creating is not enabled without db");
            throw new RuntimeException("No DB active");
        }


    }

    @Override
    public List<Submission> getAll() {

        List<Submission> submissions = new ArrayList<>();
        if (isDbEnabled) {
            repository.findAll().forEach(submissions::add);
        } else {

            canvas.getAssignments().getBody().forEach(it -> {
                submissions.add(Submission.builder()
                        .moduleCode(it.getModuleId())
                        .studentId(it.getStudentId())
                        .teacherId(it.getTeacherId())
                        .submissionId(it.getAssignmentId())
                        .grade(Grade.valueOf(it.getGrade().name()))
                        .createdAt(it.getCreatedAt())
                        .build());

            });
        }
        return submissions;
    }

    @Override
    public Submission getOne(String submissionId) {

        val response =canvas.getAssignment(submissionId).getBody();

        return Submission.builder()
                .moduleCode(response.getModuleId())
                .studentId(response.getStudentId())
                .teacherId(response.getTeacherId())
                .submissionId(response.getAssignmentId())
                .grade(Grade.valueOf(response.getGrade().name()))
                .createdAt(response.getCreatedAt())
                .build();
    }

    @Override
    public Submission verify(String submissionId) {

        val submission = getOne(submissionId);
        val ssn = studentClient.getSsnFromStudentUser(SsnFromStudentUserRequest
                .builder().studentUser(submission.getStudentId()).build()).getBody().getSsn();
        ResultResponse request = ResultResponse.builder()
                .module(submission.getModuleCode())
                .date(submission.getCreatedAt().toString())
                .grade(com.g2.studentservice.api.mock.ladok.Grade.valueOf(submission.getGrade().name()))
                .ssn(ssn)
                .build();


        ladok.setResult(submissionId, request);
        submission.setVerified(true);
        return submission;
    }

     */


}
