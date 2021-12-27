package com.example.demo.Controller;

import com.example.demo.Dto.LectureDTO;
import com.example.demo.Dto.MemberDTO;
import com.example.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {
    @Autowired
    private final LectureService service;

    @GetMapping("/main")
    public String mainpage(HttpServletRequest req){
        HttpSession session = req.getSession();
        if("1".equals(session.getAttribute("auth").toString())){
            return "/view/teacher_main.html"; //강사
        }else{
            return "/view/student_main.html";//학생
        }
    }

    @GetMapping("/makelecture")
    public String makelecture(){
        return "/view/makeLecture.html";
    }

    @PostMapping("/lectureproc")
    public String lectureproc(LectureDTO dto, HttpServletRequest req){
        System.out.println(dto.toString());
        service.save(dto,req);
        return "/main";
    }
}
