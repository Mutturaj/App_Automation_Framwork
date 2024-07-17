package com.stockBroking.qa.model;

import lombok.*;

/**
 * @author shubham.rajput
 * @date 22/02/23
 * @package model
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BuySell {
    protected String stockName;
    protected String userMobileNumber;
    protected String pinValue;
    protected String orderValue;
    protected String orderTypeValue;
    protected String productTypeValue;
    protected String limitPriceValue;
    protected String qtyValue;
    protected String triggerPriceValue;
    protected String disclosedQtyValue;
    protected String validityValue;
}
