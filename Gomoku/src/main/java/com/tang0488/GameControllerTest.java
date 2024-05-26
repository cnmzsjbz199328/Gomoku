package com.tang0488;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class GameControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private GameController gameController;

    @MockBean
    private SimpMessagingTemplate messagingTemplate;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Test
    public void testProcessMove() throws Exception {
        GameMove move = new GameMove();
        move.setRow(1);
        move.setColumn(1);

        mockMvc.perform(post("/app/move")
                        .contentType("application/json")
                        .content("{\"row\":1,\"column\":1}"))
                .andExpect(status().isOk());

        verify(messagingTemplate).convertAndSend("/topic/gameState", move);
    }
}
