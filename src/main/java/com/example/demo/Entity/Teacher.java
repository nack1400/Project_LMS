package com.example.demo.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long techerNum;

    @Column
    private String teacherId;

    @Column
    private String teacherName;

    @Builder
    public Teacher(String teacherId, String teacherName){
        this.teacherId=teacherId;
        this.teacherName=teacherName;
    }
}
