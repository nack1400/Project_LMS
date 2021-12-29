package com.example.demo.Repository;

import com.example.demo.Entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findByStudentId(String sid);

    default List<Class> findByClass(String sid, long code) {
        return null;
    }

}
