package com.example.demo.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RegistrationDTO {
    private Long stdNum;
    private Long lectureCode;
}
