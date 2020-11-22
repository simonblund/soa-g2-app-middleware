package com.g2.appmiddleware.infrastructure.rest;

import com.g2.examinationservice.api.rest.submission.SubmissionResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "essubmission-client", url = "${integration.services.examination-service.url}")
public interface ESSubmissionClient extends SubmissionResource {

}
