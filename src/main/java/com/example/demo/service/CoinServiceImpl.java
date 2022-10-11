package com.example.demo.service;

import com.example.demo.converter.CoinConverter;
import com.example.demo.entity.Coin;
import com.example.demo.exception.WebAppErrorEnum;
import com.example.demo.external.CoinDesk;
import com.example.demo.external.CoinDeskClient;
import com.example.demo.external.CoinDeskRes;
import com.example.demo.repository.CoinRepo;
import com.example.demo.rest.dto.CoinDTO;
import com.example.demo.rest.dto.CoinDeskDTO;
import com.example.demo.rest.dto.CoinUpdateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author meow
 */
@Service("coinService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoinServiceImpl implements CoinService{

    private final CoinRepo coinRepo;
    private final CoinConverter coinConverter;

    private final CoinDeskClient coinDeskClient;

    private final ObjectMapper objectMapper;

    @Override
    public List<CoinDeskDTO> listCoinDesk() {
        final CoinDeskRes res = Optional.ofNullable(coinDeskClient.getCoinDesk())
                .orElseThrow(WebAppErrorEnum.COIN_DESK_NOT_FOUND::exception);

        final LocalDateTime updatedAt = res.getTime().getUpdatedISO().toLocalDateTime();
        final Map<String, CoinDesk> coinDeskMap = res.getBpi();
        final Map<String, String> coinNameMap = coinRepo.findByCodeIn(coinDeskMap.keySet())
                .stream().collect(Collectors.toMap(Coin::getCode, Coin::getName));

        return coinDeskMap.entrySet().stream()
                .map(coinDesk -> this.buildCoinDeskDTO(coinDesk.getValue(), coinNameMap.get(coinDesk.getKey())))
                .peek( coinDeskDTO -> coinDeskDTO.setUpdatedAt(updatedAt))
                .collect(Collectors.toList());
    }

    private CoinDeskDTO buildCoinDeskDTO(final CoinDesk coinDesk, final String name) {
        return CoinDeskDTO.builder()
                .code(coinDesk.getCode())
                .name(name)
                .rate(coinDesk.getRateFloat())
                .build();
    }

    @Override
    public List<CoinDTO> listCoins() {
        return coinConverter.toCoinDTO(coinRepo.findAll());
    }

    @Override
    @Transactional
    public CoinDTO create(CoinDTO coinDTO) {
        final Coin coin = coinConverter.toCoin(coinDTO);
        return coinConverter.toCoinDTO(coinRepo.save(coin));
    }

    @Override
    @Transactional
    public CoinDTO update(final String code, CoinUpdateDTO updateDTO) {
        final Coin coin = coinRepo.findById(code).orElseThrow(WebAppErrorEnum.COIN_NOT_FOUND::exception);
        coinConverter.copyProperties(updateDTO, coin);
        return coinConverter.toCoinDTO(coinRepo.save(coin));
    }

    @Override
    @Transactional
    public void delete(String code) {
        coinRepo.deleteById(code);
    }
}
