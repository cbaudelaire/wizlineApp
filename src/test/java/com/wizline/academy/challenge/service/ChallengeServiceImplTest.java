package com.wizline.academy.challenge.service;

import com.wizline.academy.challenge.dao.ChallengeDAO;
import com.wizline.academy.challenge.model.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class ChallengeServiceImplTest {

    @Mock
    private ChallengeDAO challengeDao;

    @MockBean
    private ChallengeService challengeService;

    @BeforeEach
    public void setup() {
        challengeService = new ChallengeServiceImpl(challengeDao);
    }

    @Test
    void shouldReturnListOfStudents() {

        Student studentOne = new Student(1L, "Oscar", "Abril", "abrilrdev@gmail.com");
        Student studentTwo = new Student(2L, "Linus", "Torvalds", "linux91@gmail.com");
        List<Student> students = new ArrayList<>(Arrays.asList(studentOne,studentTwo));

        Mockito.when(challengeService.getAllStudents()).thenReturn(students);
        List<Student> result = challengeService.getAllStudents();

        Assertions.assertEquals(2, result.size());
    }

    @Test
    void shouldReturnEmptyList() {

        List<Student> students = new ArrayList<>();
        Mockito.when(challengeService.getAllStudents()).thenReturn(students);
        List<Student> result = challengeService.getAllStudents();
        Assertions.assertEquals(0, result.size());
    }


}