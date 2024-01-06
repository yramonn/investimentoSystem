package com.ramon.investmentAggregator.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_billing_address")
public class BillingAddress {

    @Id
    @Column(name = "account_id")
    private UUID id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private Integer number;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    public BillingAddress(UUID id, String street, Integer number, Account account) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.account = account;
    }

    public BillingAddress() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
