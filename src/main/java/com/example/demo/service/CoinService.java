package com.example.demo.service;

import com.example.demo.rest.dto.CoinDTO;
import com.example.demo.rest.dto.CoinDeskDTO;
import com.example.demo.rest.dto.CoinUpdateDTO;

import java.util.List;

/**
 * @author meow
 */
public interface CoinService {

    List<CoinDeskDTO> listCoinDesk();

    /**
     * list coins
     *
     * @return List<CoinDTO>
     */
    List<CoinDTO> listCoins();

    /**
     * create coin
     *
     * @param coinDTO CoinDTO
     * @return CoinDTO
     */
    CoinDTO create(CoinDTO coinDTO);

    /**
     * update coin by code
     *
     * @param code    coin id
     * @param coinDTO CoinDTO
     * @return CoinDTO
     */
    CoinDTO update(String code, CoinUpdateDTO coinDTO);

    /**
     * delete coin by code
     *
     * @param code coin id
     */
    void delete(String code);
}
