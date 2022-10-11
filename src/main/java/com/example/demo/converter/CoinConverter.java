package com.example.demo.converter;

import com.example.demo.entity.Coin;
import com.example.demo.external.CoinDesk;
import com.example.demo.rest.dto.CoinDTO;
import com.example.demo.rest.dto.CoinDeskDTO;
import com.example.demo.rest.dto.CoinUpdateDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @author meow
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, builder = @Builder(disableBuilder = true))
public interface CoinConverter {

    /**
     * convert to CoinDTO>
     *
     * @param coin Coin
     * @return CoinDTO
     */
    CoinDTO toCoinDTO(Coin coin);

    /**
     * convert to List<CoinDTO>
     *
     * @param coins List<Coin>
     * @return List<CoinDTO>
     */
    List<CoinDTO> toCoinDTO(List<Coin> coins);

    /**
     * convert to Coin
     *
     * @param dto CoinDTO
     * @return Coin
     */
    Coin toCoin(CoinDTO dto);

    /**
     * convert to List<Coin>
     *
     * @param dtos List<CoinDTO>
     * @return List<Coin>
     */
    List<Coin> toCoin(List<CoinDTO> dtos);


    /**
     * copy properties to Coin
     *
     * @param updateDTO CoinUpdateDTO
     * @param coin      Coin
     */
    void copyProperties(CoinUpdateDTO updateDTO, @MappingTarget Coin coin);


    CoinDeskDTO toCoinDeskDTO(CoinDesk coinDesk);
}
