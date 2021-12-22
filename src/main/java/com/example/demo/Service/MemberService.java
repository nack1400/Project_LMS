package com.example.demo.Service;

import com.example.demo.Dto.MemberDTO;
import com.example.demo.Entity.Member;
import com.example.demo.Repository.MemberRepository;
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

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> result = memberrepo.findById(id);
        if(result.isPresent())
            return result.get();
        else
            throw new UsernameNotFoundException("Check id");
    }

    public void save(MemberDTO dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        dto.setPwd(encoder.encode(dto.getPwd()));

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


        memberrepo.findById(dto.getId());
        if(memberrepo == null){
            return "/login";
        }else{

        }
        HttpSession session = req.getSession();

        session.setAttribute("id",dto.getId());
        session.setAttribute("auth",dto.getAuth());

        if(){
            return "/teacher_main.html"; //강사
        }else if(){
            return "/student_main.html";//학생
        }
    }
}
