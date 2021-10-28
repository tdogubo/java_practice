package com.etz.practice.repository;

import com.etz.practice.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
    Optional<CourseModel> findByTitle(String title);
}
