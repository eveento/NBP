package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Data
@Table(name = "rates")
public class Rates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no")
    private String no;

    @Column(name = "effective_date")
    private Date date;

    @Column(name = "mid")
    private Double mid;

    @ManyToOne
    @JoinColumn(name = "exchange_rate_history_id")
    private ExchangeRateHistory exchangeRateHistory;
}
