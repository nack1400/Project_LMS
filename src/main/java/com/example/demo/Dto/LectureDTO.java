package com.example.demo.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureDTO {
    private Long lectureCode;
    private String teacherId;
    private String lectureName;
    private int numOfStudents;
    private String contents;
}
