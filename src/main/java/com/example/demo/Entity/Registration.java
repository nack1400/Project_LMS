package com.example.demo.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name="tbl_registraion")
public class Registration {
    @Column
    private Long stdNum;

    @Column
    private Long lectureCode;

    @Builder
    public Registration(Long stdNum, Long lectureCode){
        this.stdNum=stdNum;
        this.lectureCode=lectureCode;
    }
}
