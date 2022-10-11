package com.example.demo.external;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * @author meow
 */
@Data
public class CoinDeskRes implements Serializable {

    private TimeInfo time;

    private String disclaimer;

    private String chartName;

    private Map<String, CoinDesk> bpi;

    @Data
    public static class TimeInfo {

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        private OffsetDateTime updatedISO;
    }
}
