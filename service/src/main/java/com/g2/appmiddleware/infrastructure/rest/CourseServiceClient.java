package com.g2.appmiddleware.infrastructure.rest;

import com.g2.courseservice.api.rest.CourseServiceResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "course-service-client", url = "${integration.services.course-service.url}")
public interface CourseServiceClient extends CourseServiceResource {
}
