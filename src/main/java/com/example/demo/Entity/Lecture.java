package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureCode;

    @Column(name = "lectureName")
    private String lectureName;

    @Column(name = "numOfStudents")
    private int numOfStudents;

    @Column(name = "teacherId")
    private String teacherId;

    @Column(name = "contents")
    private String contents;

    @Builder
    public Lecture(String lectureName, int numOfStudents, String teacherId, String contents){
        this.lectureName=lectureName;
        this.numOfStudents=numOfStudents;
        this.teacherId=teacherId;
        this.contents=contents;
    }
}
