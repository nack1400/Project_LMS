package com.example.demo.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    @GetMapping("/join")
    public String joinpage(){
        return "/view/join.html";
    }

}
