package ru.tsyrikov.betoola.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.tsyrikov.betoola.Application;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class MoneyExchangeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void whenBuy100GbpCalculateInvoked_thenReturn200() throws Exception {
        mockMvc.perform(post("/buy-100-gbp/calculate"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalAmount", is(126.22)));
    }

    @Test
    public void whenSell100EuroCalculateInvoked_thenReturn200() throws Exception {
        mockMvc.perform(post("/sell-100-euro/calculate"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalAmount", is(79.2)));
    }
}
