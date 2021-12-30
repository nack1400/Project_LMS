package com.example.demo.Repository;

import com.example.demo.Entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByTeacherId(String tid);
//    List<Lecture> findByLectureCode(Long code);
    Lecture findByLectureCode(Long code);
}
