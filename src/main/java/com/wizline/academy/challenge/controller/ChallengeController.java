package com.wizline.academy.challenge.controller;

import com.wizline.academy.challenge.model.entity.Student;
import com.wizline.academy.challenge.service.ChallengeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @Value("${author.message}")
    private String INIT_MESSAGE;

    @GetMapping("/")
    public String index(){
        return INIT_MESSAGE;
    }


    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return challengeService.getAllStudents();
    }

}
