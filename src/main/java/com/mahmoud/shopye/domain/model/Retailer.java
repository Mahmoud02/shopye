package com.mahmoud.shopye.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public class Retailer {
    private Long id;
    private String name;
    private RETAILER_STATUS retailerStatus;
    @Getter
    private BigDecimal Balance;

    public boolean isRetailerEligibleForOrderCreation(){
        return retailerStatus.equals(RETAILER_STATUS.ALLOW) && Balance.compareTo(new BigDecimal(0)) > 0;
    }
}
enum RETAILER_STATUS {
    ALLOW,BAN;
}
