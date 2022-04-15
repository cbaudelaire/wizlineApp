package com.wizline.academy.challenge.service;

import com.wizline.academy.challenge.dao.ChallengeDAO;
import com.wizline.academy.challenge.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    private final ChallengeDAO challengeDAO;

    public ChallengeServiceImpl(ChallengeDAO challengeDAO){
        this.challengeDAO = challengeDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return challengeDAO.findAll();
    }

}
