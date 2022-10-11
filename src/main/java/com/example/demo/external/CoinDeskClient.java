package com.example.demo.external;

import feign.codec.Decoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

/**
 * @author meow
 */
@FeignClient(value = "coin-desk-client", url = "${coindesk.endpoint}", configuration = CoinDeskClient.FeignConfiguration.class)
public interface CoinDeskClient {

    @GetMapping(value = "/v1/bpi/currentprice.json", produces = "application/json")
    CoinDeskRes getCoinDesk();



    // TODO
    class FeignConfiguration {
        @Bean
        public Decoder feignDecoder() {
            return new SpringDecoder(() -> new HttpMessageConverters(new CustomMappingJackson2HttpMessageConverter() ));
        }
    }

    class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        @Override
        public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
            super.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        }
    }
}
