package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class ExchangeRateHistoryDTO implements Serializable{

    @JsonProperty(value = "table")
    private String table;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "rates")
    private List<RateDTO> rates;

}
