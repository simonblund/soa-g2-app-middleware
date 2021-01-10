package com.g2.appmiddleware.api.rest;

public class UrlPaths {
    public static final String BASE_URI = "/app";
    public static final String V1 = "/V1";
    public static final String EXAMINATION_RESOURCE = BASE_URI + V1 + "/examination";
    public static final String EXAMINATION = EXAMINATION_RESOURCE + "/{examinationCode}";
    public static final String EXAMINATION_SUBMISSIONS = EXAMINATION + "/submissions";


    public static final String SUBMISSION_RESOURCE = BASE_URI + V1 + "/submission";
    public static final String SUBMISSION = SUBMISSION_RESOURCE + "/{submissionId}";
    public static final String SUBMISSION_VERIFY = SUBMISSION + "/verify";

    public static final String COURSE_RESOURCE = BASE_URI + V1 + "/courses";
    public static final String GET_COURSE = COURSE_RESOURCE + "/{courseCode}";

    public static final String COURSE_OCCASIONS = COURSE_RESOURCE + "/occasions";
    public static final String GET_COURSE_INSTANCE = COURSE_OCCASIONS+"/{courseOccasionId}";

    public static final String TEACHER_RESOURCE = BASE_URI + V1 + "/teachers";
    public static final String GET_TEACHER = TEACHER_RESOURCE + "/{teacherId}";

    public static final String SCHEDULE_RESOURCE = BASE_URI + V1 + "/schedules";
    public static final String GET_OCCASION_SCHEDULE = SCHEDULE_RESOURCE + "/{courseOccasionId}";

    public static final String BOOKING_RESOURCE = BASE_URI + V1 + "/bookings";
    public static final String GET_FROM_BOOKING_ID = BOOKING_RESOURCE + "/{bookingId}";

    public static final String BOOKING_ROOM_RESOURCE = BOOKING_RESOURCE + "/rooms";
    public static final String GET_FROM_ROOM_ID = BOOKING_ROOM_RESOURCE +"/{roomId}";

    public static final String BOOKING_RESOURCE_RESOURCE = BOOKING_RESOURCE + "/resources";
    public static final String GET_FROM_RESOURCE_ID = BOOKING_RESOURCE_RESOURCE + "/{resourceId}";
}

