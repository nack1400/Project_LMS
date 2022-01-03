package com.example.demo.Controller;

import com.example.demo.Dto.MemberDTO;
import com.example.demo.Service.MemberService;
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
public class LoginController {

    @Autowired
    private final MemberService service;

    @GetMapping("/")
    public String loginpage(){
        return "/view/index.html";
    }

    @GetMapping("/join")
    public String joinpage(){
        return "/view/join.html";
    }

    @PostMapping("/joinproc")
    public String joinprocpage(MemberDTO dto){
        System.out.println(dto.toString());
        service.save(dto);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(MemberDTO dto, HttpServletRequest req){
//        HttpSession session = req.getSession();
//
//        session.setAttribute("id",dto.getId());
//        session.setAttribute("auth",service.toString());
        return service.login(dto,req);
    }
}
