package com.example.demo.Controller;

import com.example.demo.Dto.LectureDTO;
import com.example.demo.Entity.Lecture;
import com.example.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLOutput;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LectureController {

    @Autowired
    private final LectureService service;

    @GetMapping("/lectureproc")
    public String lectureProc(){
        return "/view/makeLecture.html";
    }

    @PostMapping("/makelecture")
    public String lectureMake(LectureDTO dto, HttpServletRequest req){
        System.out.println(dto.toString());
        service.save(dto,req);
        return "redirect:/main";
    }

}
