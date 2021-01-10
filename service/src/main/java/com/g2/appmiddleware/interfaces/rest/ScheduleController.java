package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.infrastructure.rest.ScheduleServiceClient;
import com.g2.scheduleservice.api.rest.schedule.CourseOccasionScheduleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceClient scheduleServiceClient;

    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.GET_OCCASION_SCHEDULE)
    ResponseEntity<CourseOccasionScheduleResponse> getFromOccasionId(@PathVariable long courseOccasionId, @RequestHeader("CanvasToken") String canvasToken, @RequestHeader("CanvasUser") int canvasUser){
        log.info("A GET request to {} has arrived with courseOccasionId {}", UrlPaths.GET_COURSE_INSTANCE, courseOccasionId);
        return scheduleServiceClient.getFromOccasionId(courseOccasionId, canvasToken, canvasUser);

    }

    @CrossOrigin(origins = "*")
    @PostMapping(UrlPaths.GET_OCCASION_SCHEDULE)
    ResponseEntity<CourseOccasionScheduleResponse> saveToCanvas(@PathVariable long courseOccasionId, @RequestHeader("CanvasToken") String canvasToken, @RequestHeader("CanvasUser") int canvasUser, @RequestBody CourseOccasionScheduleResponse request){
        log.info("A POST request to {} has arrived with courseOccasionId {}", UrlPaths.GET_COURSE_INSTANCE, courseOccasionId);
        return scheduleServiceClient.saveToCanvas(courseOccasionId, canvasToken, canvasUser, request);

    }
}
