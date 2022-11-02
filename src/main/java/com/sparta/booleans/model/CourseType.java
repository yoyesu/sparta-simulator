package com.sparta.booleans.model;

public enum CourseType {
    JAVA(1),
    CSHARP(2),
    DATA(3),
    DEVOPS(4),
    BUSINESS(5);

    final int intRandomAssigner;

    CourseType (int intRandomAssigner) {
        this.intRandomAssigner = intRandomAssigner;
    }


}
