package com.incra.models;

/**
 * Created by jeff on 9/13/15.
 */
public class DonationValue {
    private Long creditCardId;
    private Float amount;

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
