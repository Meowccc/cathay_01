package com.example.demo.rest.controller;

import com.example.demo.Cathay01Application;
import com.example.demo.external.CoinDeskClient;
import com.example.demo.external.CoinDeskRes;
import com.example.demo.rest.dto.CoinDTO;
import com.example.demo.rest.dto.CoinUpdateDTO;
import com.example.demo.service.CoinService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author meow
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Cathay01Application.class})
@AutoConfigureMockMvc
class CoinControllerTest{

    private final String COIN_URI = "/coins";

    @MockBean
    private CoinService coinService;

    @Autowired
    private CoinDeskClient coinDeskClient;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void listCoinDesk() throws Exception {
        final CoinDeskRes res = coinDeskClient.getCoinDesk();
        assertNotNull(res);
        assertTrue(res.getBpi().size() > 0);
    }

    @Test
    void listCoinDeskAndConverter() throws Exception {
        mockMvc.perform(get("/coindesk"))
                .andExpect(status().isOk());
    }

    @Test
    void listCoins() throws Exception {

        final List<CoinDTO> coins = Collections.singletonList(CoinDTO.builder()
                .code("TWD")
                .name("台幣")
                .build());
        final String resJson = objectMapper.writeValueAsString(coins);
        Mockito.when(coinService.listCoins()).thenReturn(coins);

        mockMvc.perform(get(COIN_URI))
                .andExpect(status().isOk())
                .andExpect(content().json(resJson));

    }

    @Test
    void create() throws Exception {
        final CoinDTO coinDTO = CoinDTO.builder()
                .code("TWD")
                .name("台幣")
                .build();
        final String json = objectMapper.writeValueAsString(coinDTO);
        Mockito.when(coinService.create(coinDTO)).thenReturn(coinDTO);

        mockMvc.perform(post(COIN_URI).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    void update() throws Exception {
        final String coinCode = "TWD";
        final String coinName = "台幣";
        final CoinUpdateDTO coinUpdateDTO = CoinUpdateDTO.builder()
                .name(coinName)
                .build();

        final String json = objectMapper.writeValueAsString(coinUpdateDTO);

        Mockito.when(coinService.update(coinCode, coinUpdateDTO)).thenReturn(CoinDTO.builder()
                .code(coinCode)
                .name(coinName)
                .build());

        mockMvc.perform(put(COIN_URI + "/" + coinCode).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    void delete() throws Exception {
        final String coinCode = "TWD";
        Mockito.doNothing().when(coinService).delete(coinCode);
        mockMvc.perform(MockMvcRequestBuilders.delete(COIN_URI + "/" + coinCode))
                .andExpect(status().isOk());
    }
}