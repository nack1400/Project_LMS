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

    @Column
    private String lectureName;

    @Column
    private int numOfStudents;

    @Column
    private String teacherId;

    @Column
    private String contents;

    @Builder
    public Lecture(String lectureName, int numOfStudents, String teacherId, String contents){
        this.lectureName=lectureName;
        this.numOfStudents=numOfStudents;
        this.teacherId=teacherId;
        this.contents=contents;
    }
}
