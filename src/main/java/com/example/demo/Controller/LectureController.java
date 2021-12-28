package com.example.demo.Controller;

import com.example.demo.Dto.LectureDTO;
import com.example.demo.Entity.Lecture;
import com.example.demo.Repository.LectureRepository;
import com.example.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LectureController {

    @Autowired
    private final LectureService service;


}
