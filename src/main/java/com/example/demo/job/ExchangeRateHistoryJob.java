package com.example.demo.job;

import com.example.demo.dto.ExchangeRateHistoryDTO;
import com.example.demo.enums.Currency;
import com.example.demo.enums.TableKind;
import com.example.demo.feign.NbpClient;
import com.example.demo.service.ExchangeRateHistoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class ExchangeRateHistoryJob {

    @Autowired
    private NbpClient nbpClient;

    @Autowired
    private ExchangeRateHistoryService exchangeRateHistoryService;

    @Scheduled(cron = "${exchange.rate.history.cron}")
    @Transactional
    public void NBPExchangeRateHistoryJob() {
        ExchangeRateHistoryDTO exchangeRateHistoryDTO = nbpClient.getExchangeRateHistory(TableKind.A.getName(), Currency.CHF.name());
        try {
            exchangeRateHistoryService.saveExchangeRateHistory(exchangeRateHistoryDTO);
        }catch (Exception e) {
            log.error("Masz problem kolego xD",e);
        }
    }
}
