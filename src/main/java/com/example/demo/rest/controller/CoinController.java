package com.example.demo.rest.controller;

import com.example.demo.rest.dto.CoinDTO;
import com.example.demo.rest.dto.CoinUpdateDTO;
import com.example.demo.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author meow
 */
@RestController
@RequestMapping("coins")
@RequiredArgsConstructor
public class CoinController {

    private final CoinService coinService;

    @GetMapping
    public List<CoinDTO> listCoins() {
        return coinService.listCoins();
    }

    @PostMapping
    public CoinDTO create(@RequestBody CoinDTO coinDTO) {
        return coinService.create(coinDTO);
    }

    @PutMapping("{code}")
    public CoinDTO update(@PathVariable("code") String code, @RequestBody CoinUpdateDTO updateDTO) {
        return coinService.update(code, updateDTO);
    }

    @DeleteMapping("{code}")
    public void delete(@PathVariable("code") String code) {
        coinService.delete(code);
    }
}
