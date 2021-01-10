package com.g2.appmiddleware.infrastructure.rest;

import com.g2.scheduleservice.api.rest.ScheduleServiceResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "schedule-service-client", url = "${integration.services.schedule-service.url}")
public interface ScheduleServiceClient extends ScheduleServiceResource {

}
