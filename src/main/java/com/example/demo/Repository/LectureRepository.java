package com.example.demo.Repository;

import com.example.demo.Entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
