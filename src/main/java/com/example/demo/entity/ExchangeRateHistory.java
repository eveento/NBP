package com.example.demo.entity;

import com.example.demo.enums.TableKind;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "exchange_rate_history")
public class ExchangeRateHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "currency")
    private String currency;

    @Column(name = "kind")
    @Enumerated(EnumType.STRING)
    private TableKind kind;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exchangeRateHistory")
    private List<Rates> rates;
}


