package com.example.demo.case2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Controller2.class)
@Import({Service2.class})
class Controller2Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service2 service;


    @Test
    @DisplayName("json1 결과값 체크")
    public void json1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/json1"))
                .andExpect(status().isOk())
                ;
    }

    @Test
    @DisplayName("json2 결과값 체크")
    public void json2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/json2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("홍길동"))
                .andExpect(jsonPath("$.age").value(28));
    }

    @Test
    @DisplayName("json3 결과값 체크")
    public void json3() throws Exception {
        given(service.getUserDTO()).willReturn(new UserDTO("김길동", 18));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/json2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("김길동"))
                .andExpect(jsonPath("$.age").value(18));
    }
}