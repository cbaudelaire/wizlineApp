package com.wizline.academy.challenge.dao;

import com.wizline.academy.challenge.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeDAO extends JpaRepository<Student, Long> {
}
