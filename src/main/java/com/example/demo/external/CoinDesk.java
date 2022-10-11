package com.example.demo.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

/**
 * @author meow
 */
@Data
public class CoinDesk {

    private String code;

    private String symbol;

    //        @NumberFormat(pattern = "#,###.0000")
    private String rate;

    private String description;

    @JsonProperty("rate_float")
    @NumberFormat(pattern = "#.0000")
    private BigDecimal rateFloat;
}
