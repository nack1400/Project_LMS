package com.example.demo.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    @GetMapping("/")
    public String loginpage(){
        return "/view/index.html";
    }

    @GetMapping("/join")
    public String joinpage(){
        return "/view/join.html";
    }

    @GetMapping("/main")
    public String mainpage(){
        return "/view/main.html";
    }
}
