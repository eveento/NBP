package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class RateDTO implements Serializable {

    @JsonProperty(value = "no")
    private String no;
    @JsonProperty(value = "effectiveDate")
    private Date effectiveDate;
    @JsonProperty(value = "mid")
    private Double mid;

}
