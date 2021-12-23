package com.example.demo.Repository;

import com.example.demo.Entity.Lecture;
import com.example.demo.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Optional<Lecture> findById(String teacherId);
}
