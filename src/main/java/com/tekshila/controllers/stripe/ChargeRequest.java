package com.tekshila.controllers.stripe;

import lombok.Data;

import lombok.Data;

@Data
public class ChargeRequest {

    public enum Currency {
        EUR, USD;
    }
    private String description;
    private int amount; // cents
    private Currency currency;
    private String stripeEmail;
    private String stripeToken;


    private String courseId;

    public String getDescription() {
        return description;
    }
    public int getAmount() {
        return amount;
    }
    public Currency getCurrency() {
        return currency;
    }
    public String getStripeEmail() {
        return stripeEmail;
    }
    public String getStripeToken() {
        return stripeToken;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
