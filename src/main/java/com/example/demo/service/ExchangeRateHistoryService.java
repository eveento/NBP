package com.example.demo.service;

import com.example.demo.dto.ExchangeRateHistoryDTO;
import com.example.demo.entity.ExchangeRateHistory;
import com.example.demo.entity.Rates;
import com.example.demo.enums.TableKind;
import com.example.demo.repository.ExchangeRatesHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class ExchangeRateHistoryService {

    private ExchangeRatesHistoryRepository exchangeRatesHistoryRepository;

    @Autowired
    public ExchangeRateHistoryService(ExchangeRatesHistoryRepository exchangeRatesHistoryRepository) {
        this.exchangeRatesHistoryRepository = exchangeRatesHistoryRepository;
    }

    @Transactional
    public void saveExchangeRateHistory(ExchangeRateHistoryDTO exchangeRateHistoryDTOS) {
        ExchangeRateHistory exchangeRateHistory = createExchangeRateHistoryEntity(exchangeRateHistoryDTOS);
        exchangeRatesHistoryRepository.save(exchangeRateHistory);
    }

    private ExchangeRateHistory createExchangeRateHistoryEntity(ExchangeRateHistoryDTO exchangeRateHistoryDTOS) {
        ExchangeRateHistory exchangeRateHistory = new ExchangeRateHistory();
        exchangeRateHistory.setKind(TableKind.findName(exchangeRateHistoryDTOS.getTable()));
        exchangeRateHistory.setCode(exchangeRateHistoryDTOS.getCode());
        exchangeRateHistory.setCurrency(exchangeRateHistoryDTOS.getCurrency());
        exchangeRateHistory.setRates(exchangeRateHistoryDTOS.getRates().stream()
                .map(item -> Rates
                        .builder()
                        .no(item.getNo())
                        .mid(item.getMid())
                        .date(item.getEffectiveDate())
                        .exchangeRateHistory(exchangeRateHistory)
                        .build()).collect(Collectors.toList()));
        return exchangeRateHistory;
    }
}
