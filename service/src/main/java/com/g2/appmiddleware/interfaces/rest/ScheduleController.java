package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.infrastructure.rest.ScheduleServiceClient;
import com.g2.scheduleservice.api.rest.resource.BookingResponse;
import com.g2.scheduleservice.api.rest.resource.ResourceResponse;
import com.g2.scheduleservice.api.rest.resource.RoomResponse;
import com.g2.scheduleservice.api.rest.schedule.CourseOccasionScheduleResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.g2.appmiddleware.api.rest.UrlPaths.*;

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

    
    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_RESOURCE)
    ResponseEntity<List<BookingResponse>> getAllBookings(){
        return scheduleServiceClient.getAllBookings();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(GET_FROM_RESOURCE_ID)
    ResponseEntity<BookingResponse> bookResource(@PathVariable long resourceId, @RequestBody BookingResponse request){
        return scheduleServiceClient.bookResource(resourceId,request);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(GET_FROM_ROOM_ID)
    ResponseEntity<BookingResponse> bookRoom(@PathVariable long roomId, @RequestBody BookingResponse request){
        return scheduleServiceClient.bookRoom(roomId, request);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_RESOURCE_RESOURCE)
    ResponseEntity<List<ResourceResponse>> getAllResources(){
        return scheduleServiceClient.getAllResources();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_ROOM_RESOURCE)
    ResponseEntity<List<RoomResponse>> getAllRooms(){
        return scheduleServiceClient.getAllRooms();
    }
}
