package com.example.demo.Service;

import com.example.demo.Dto.LectureDTO;
import com.example.demo.Entity.Lecture;
import com.example.demo.Repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    @Autowired
    private final LectureRepository lecturerepo;

    public void save(LectureDTO dto, HttpServletRequest req){
        HttpSession session = req.getSession();
        Lecture lecture = Lecture.builder()
                .teacherId(session.getAttribute("id").toString())
                .lectureName(dto.getLectureName())
                .contents(dto.getContents())
                .build();
        lecturerepo.save(lecture);
    }
    public List<Lecture> findByTeacherId(String tid){
        return lecturerepo.findByTeacherId(tid);
    }
    public List<Lecture> findAll(){
        return lecturerepo.findAll();
    }
//    public List<Lecture> findByLectureCode(Long code){
//        return lecturerepo.findByLectureCode(code);
//    }
    public Lecture findByLectureCode(Long code){
        return lecturerepo.findByLectureCode(code);
    }
}
