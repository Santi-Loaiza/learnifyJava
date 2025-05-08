package com.example.learnifyJava.helpers;

public enum APIMessages {
    ERROR_TEACHER_NOT_FOUND("The teacher you are trying to find cannot be found in the database"),
    ERROR_STUDENT_NOT_FOUND("The student you are trying to find cannot be found in the database"),
    ERROR_ATTENDANCE_NOT_FOUND("The attendance you are trying to find cannot be found in the database"),
    ERROR_COURSE_NOT_FOUND("The course you are trying to find cannot be found in the database"),
    ERROR_GRADE_NOT_FOUND("The grade you are trying to find cannot be found in the database"),
    ERROR_REGISTRATION_NOT_FOUND("The registration you are trying to find cannot be found in the database"),
    ERROR_SUBJECT_NOT_FOUND("The subject you are trying to find cannot be found in the database"),
    ERROR_USER_NOT_FOUND("The user you are trying to find cannot be found in the database");

    private String message;

    APIMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
