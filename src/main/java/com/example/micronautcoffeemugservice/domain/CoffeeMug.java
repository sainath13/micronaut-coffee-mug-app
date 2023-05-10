package com.example.micronautcoffeemugservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeMug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String coffeeMugType;

    private Integer quantity;

    private Integer count;

    private String skuCode;

    private String displayName;

    private Double priceInUsd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoffeeMugType() {
        return coffeeMugType;
    }

    public void setCoffeeMugType(String coffeeMugType) {
        this.coffeeMugType = coffeeMugType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Double getPriceInUsd() {
        return priceInUsd;
    }

    public void setPriceInUsd(Double priceInUsd) {
        this.priceInUsd = priceInUsd;
    }
}
