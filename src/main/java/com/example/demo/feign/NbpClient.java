package com.example.demo.feign;

import com.example.demo.config.FeignConfiguration;
import com.example.demo.dto.ExchangeRateHistoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "nbpExchangeRateHistory", decode404 = false, url = "${nbp.exchange.rate.history.url}", configuration = FeignConfiguration.class)
public interface NbpClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/exchangerates/rates/{tableKind}/{code}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ExchangeRateHistoryDTO getExchangeRateHistory(@PathVariable("tableKind") String tableKind, @PathVariable("code") String code);
}
