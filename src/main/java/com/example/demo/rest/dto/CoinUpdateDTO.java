package com.example.demo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author meow
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoinUpdateDTO {

    private String name;
}
