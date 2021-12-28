package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ClassCode;

    @Column(name= "studentId")
    private String studentId;

    @Column(name= "lectureCode")
    private long lectureCode;

    @Builder
    public Class(String studentId, long lectureCode){
        this.studentId=studentId;
        this.lectureCode=lectureCode;
    }
}
