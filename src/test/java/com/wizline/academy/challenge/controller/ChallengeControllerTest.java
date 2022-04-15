package com.wizline.academy.challenge.controller;

import com.wizline.academy.challenge.model.entity.Student;
import com.wizline.academy.challenge.service.ChallengeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChallengeController.class)
class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChallengeService challengeService;

    @Value("${author.message}")
    private String MESSAGE_FROM_PROPERTIES;

    @BeforeEach
    public void setup() {
    }

    @Test
    void shouldReturnHelloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("Hello World!")));
    }

    @Test
    void shouldReturnUserMessageFromPropertiesFile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo(MESSAGE_FROM_PROPERTIES)));
    }

    @Test
    void getStudents() throws Exception {

        Student studentOne = new Student(1L, "Oscar", "Abril", "abrilrdev@gmail.com");
        Student studentTwo = new Student(2L, "Linus", "Torvalds", "linux91@gmail.com");
        List<Student> students = new ArrayList<>(Arrays.asList(studentOne,studentTwo));

        Mockito.when(challengeService.getAllStudents())
                .thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Oscar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Abril"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("abrilrdev@gmail.com"));
    }
}