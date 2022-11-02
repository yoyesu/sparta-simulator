package com.sparta.booleans.exceptions;

public class CourseTypeNotFound extends RuntimeException{

    @Override
    public String getMessage() {
        return "Course Type Not Found!";
    }
}
