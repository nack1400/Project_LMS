package com.example.demo.Controller;

import com.example.demo.Dto.LectureDTO;
import com.example.demo.Dto.MemberDTO;
import com.example.demo.Entity.Lecture;
import com.example.demo.Service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {
    @Autowired
    private final LectureService service;

    @GetMapping("/main")
    public String mainpage(LectureDTO dto,HttpServletRequest req, Model model){
        HttpSession session = req.getSession();

        List<Lecture> lecture = service.findByTeacherId(session.getAttribute("id").toString());
        System.out.println("세션 아이디 : " + session.getAttribute("id").toString());
        model.addAttribute("lecture", lecture);
        System.out.println("확인 : "+lecture.toString());
        if("1".equals(session.getAttribute("auth").toString())){
            return "/view/teacher_main.html"; //강사
        }else{
            return "/view/student_main.html";//학생
        }
    }

//    @GetMapping("/makelecture")
//    public String makelecture(){
//        return "/view/makeLecture.html";
//    }
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
//
//    @PostMapping("/lectureproc")
//    public String lectureproc(LectureDTO dto, HttpServletRequest req){
//        System.out.println(dto.toString());
//        service.save(dto,req);
//        return "/main";
//    }

    @GetMapping("/lecturelist")
    public String lectureList(LectureDTO dto,HttpServletRequest req, Model model){
        List<Lecture> lecture = service.findByTeacherId(dto.getTeacherId());
        model.addAttribute("lecture", lecture);
        //여기까지
        System.out.println(lecture);
        return "redirect:/main";
    }
}
