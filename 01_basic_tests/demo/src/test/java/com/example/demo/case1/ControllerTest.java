package com.example.demo.case1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Controller.class)
@Import({Service.class})
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("성공_getText_테스트")
    public void getText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/case1"))
                .andExpect(status().isOk())
                .andExpect(content().string("case1"))
        ;
    }
}
