package com.example.demo.Service;

import com.example.demo.Dto.ClassDTO;
import com.example.demo.Entity.Class;
import com.example.demo.Repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {
    @Autowired
    private final ClassRepository classrepo;

    public void save(ClassDTO dto, HttpServletRequest req){
        HttpSession session = req.getSession();
        Class tmp = Class.builder()
                .studentId(session.getAttribute("id").toString())
                .lectureCode(Long.parseLong(req.getParameter("code")))
                .build();
        classrepo.save(tmp);
    }
    public List<Class> findByStudentId(String sid){
        return classrepo.findByStudentId(sid);
    }

    public List<Class> findByClass(String sid, long code){
        return classrepo.findByClass(sid,code);
    }
}
