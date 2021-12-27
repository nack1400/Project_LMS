package com.example.demo.Service;

import com.example.demo.Dto.MemberDTO;
import com.example.demo.Entity.Member;
import com.example.demo.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    @Autowired
    private final MemberRepository memberrepo;

    private final BCryptPasswordEncoder tmp = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> result = memberrepo.findById(id);
        if(result.isPresent())
            return result.get();
        else
            throw new UsernameNotFoundException("Check id");
    }

    public void save(MemberDTO dto){
//        BCryptPasswordEncoder tmp = new BCryptPasswordEncoder();
        dto.setPwd(tmp.encode(dto.getPwd()));

        Member member = Member.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .pwd(dto.getPwd())
                .auth(dto.getAuth())
                .build();

        memberrepo.save(member);
    }

    public String login(MemberDTO dto, HttpServletRequest req){

        Optional<Member> member = memberrepo.findById(dto.getId());

        if(member.isPresent()){
            if(tmp.matches(dto.getPwd(),member.get().getPwd())){
                    System.out.println("로그인 성공");
                }else{
                    System.out.println("비밀번호가 틀렸습니다");
                    System.out.println("멤버패스워드 : "  + member.get().getPwd());
                    System.out.println("패스워드 : "  + tmp.encode(dto.getPwd()));
                    return "redirect:/";
                }

        }else{
            System.out.println("등록된 아이디가 없습니다");
            return "redirect:/";
        }

        HttpSession session = req.getSession();
        session.setAttribute("auth",member.get().getAuth());
        session.setAttribute("id",dto.getId());
//        System.out.println(dto.getId());
//        System.out.println(dto.getAuth());
//        System.out.println(session.getAttribute("id"));
//        System.out.println(session.getAttribute("auth"));

        return "redirect:/main";
//        if(dto.getAuth() == 1){
//            return "/view/teacher_main.html"; //강사
//        }else{
//            return "/view/student_main.html";//학생
//        }
    }
}
