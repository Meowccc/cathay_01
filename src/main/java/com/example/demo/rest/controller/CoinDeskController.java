package com.example.demo.rest.controller;

import com.example.demo.rest.dto.CoinDeskDTO;
import com.example.demo.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author meow
 */
@RestController
@RequestMapping("coindesk")
@RequiredArgsConstructor
public class CoinDeskController {


    private final CoinService coinService;

    @GetMapping
    public List<CoinDeskDTO> list() {
        return coinService.listCoinDesk();
    }
}
