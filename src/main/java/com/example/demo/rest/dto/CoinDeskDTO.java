package com.example.demo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author meow
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinDeskDTO {

    private String code;

    private String name;

    private BigDecimal rate;

    private LocalDateTime updatedAt;
}
