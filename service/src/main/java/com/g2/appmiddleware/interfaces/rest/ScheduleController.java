package com.g2.appmiddleware.interfaces.rest;

import com.g2.appmiddleware.api.rest.UrlPaths;
import com.g2.appmiddleware.infrastructure.rest.ScheduleServiceClient;
import com.g2.scheduleservice.api.rest.resource.BookingResponse;
import com.g2.scheduleservice.api.rest.resource.ResourceResponse;
import com.g2.scheduleservice.api.rest.resource.RoomResponse;
import com.g2.scheduleservice.api.rest.schedule.CourseOccasionScheduleResponse;
import com.g2.scheduleservice.api.rest.schedule.ReservationRequest;
import com.g2.scheduleservice.api.rest.schedule.ReservationResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Operation(summary = "Returns schedule for a courseoccasion either from TE or canvas, depending on where it exists")
    @CrossOrigin(origins = "*")
    @GetMapping(UrlPaths.GET_OCCASION_SCHEDULE)
    ResponseEntity<CourseOccasionScheduleResponse> getFromOccasionId(@PathVariable long courseOccasionId, @RequestHeader("CanvasToken") String canvasToken, @RequestHeader("CanvasUser") int canvasUser){
        log.info("A GET request to {} has arrived with courseOccasionId {}", UrlPaths.GET_COURSE_INSTANCE, courseOccasionId);
        return scheduleServiceClient.getFromOccasionId(courseOccasionId, canvasToken, canvasUser);

    }

    @Operation(summary = "Saves schedule for course occasion to canvas",
            description = "Can be sent in multiple times per course occasion. ONLY fields in reservation object need to be filled in.")

    @CrossOrigin(origins = "*")
    @PostMapping(GET_OCCASION_SCHEDULE)
    ResponseEntity<ReservationResponse> saveToCanvas(@PathVariable long courseOccasionId, @RequestHeader("CanvasToken") String canvasToken, @RequestHeader("CanvasUser") int canvasUser, @RequestBody ReservationRequest request){
        log.info("A POST request to {} has arrived with courseOccasionId {}", UrlPaths.GET_COURSE_INSTANCE, courseOccasionId);
        return scheduleServiceClient.saveToCanvas(courseOccasionId, canvasToken, canvasUser, request);

    }


    @Operation(summary = "Returns all ROOM or RESOURCE bookings ever")
    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_RESOURCE)
    ResponseEntity<List<BookingResponse>> getAllBookings(){
        return scheduleServiceClient.getAllBookings();
    }

    @Operation(summary = "Books a resource using the resources ID. DO NOT FILL IN ROOM OR RESOURCE INFO id is taken from path")
    @CrossOrigin(origins = "*")
    @PostMapping(GET_FROM_RESOURCE_ID)
    ResponseEntity<BookingResponse> bookResource(@PathVariable long resourceId, @RequestBody BookingResponse request){
        return scheduleServiceClient.bookResource(resourceId,request);
    }

    @Operation(summary = "Books a ROOM using the room ID. DO NOT FILL IN ROOM OR RESOURCE INFO id is taken from path")
    @CrossOrigin(origins = "*")
    @PostMapping(GET_FROM_ROOM_ID)
    ResponseEntity<BookingResponse> bookRoom(@PathVariable long roomId, @RequestBody BookingResponse request){
        return scheduleServiceClient.bookRoom(roomId, request);
    }

    @Operation(summary = "Returns a list of all resources")
    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_RESOURCE_RESOURCE)
    ResponseEntity<List<ResourceResponse>> getAllResources(){
        return scheduleServiceClient.getAllResources();
    }

    @Operation(summary = "Returns a list of all rooms")
    @CrossOrigin(origins = "*")
    @GetMapping(BOOKING_ROOM_RESOURCE)
    ResponseEntity<List<RoomResponse>> getAllRooms(){
        return scheduleServiceClient.getAllRooms();
    }
}
