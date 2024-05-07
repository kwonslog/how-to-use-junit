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

@WebMvcTest(controllers = Controller1.class)
@Import({Service1.class})
class Controller1Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET_매소드호출")
    public void case1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/case1"))
                .andExpect(status().isOk())
                .andExpect(content().string("case1"))
        ;
    }

    @Test
    @DisplayName("POST_메소드호출")
    public void case2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/case2"))
                .andExpect(status().isOk())
                .andExpect(content().string("case2"));
    }

    @Test
    @DisplayName("PUT_메소드호출")
    public void case3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/case3"))
                .andExpect(status().isOk())
                .andExpect(content().string("case3"));
    }

    @Test
    @DisplayName("DELETE_메소드호출")
    public void case4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/case4"))
                .andExpect(status().isOk())
                .andExpect(content().string("case4"));
    }
}
