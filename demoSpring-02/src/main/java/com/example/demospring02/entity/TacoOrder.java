package com.example.demospring02.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * taco_order
 * @author 
 */
public class TacoOrder implements Serializable {
    private String id;

    private String delivery_Name;

    private String delivery_Street;

    private String delivery_City;

    private String delivery_State;

    private String delivery_Zip;

    private String cc_number;

    private String cc_expiration;

    private String cc_cvv;

    private Date placed_at;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelivery_Name() {
        return delivery_Name;
    }

    public void setDelivery_Name(String delivery_Name) {
        this.delivery_Name = delivery_Name;
    }

    public String getDelivery_Street() {
        return delivery_Street;
    }

    public void setDelivery_Street(String delivery_Street) {
        this.delivery_Street = delivery_Street;
    }

    public String getDelivery_City() {
        return delivery_City;
    }

    public void setDelivery_City(String delivery_City) {
        this.delivery_City = delivery_City;
    }

    public String getDelivery_State() {
        return delivery_State;
    }

    public void setDelivery_State(String delivery_State) {
        this.delivery_State = delivery_State;
    }

    public String getDelivery_Zip() {
        return delivery_Zip;
    }

    public void setDelivery_Zip(String delivery_Zip) {
        this.delivery_Zip = delivery_Zip;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_expiration() {
        return cc_expiration;
    }

    public void setCc_expiration(String cc_expiration) {
        this.cc_expiration = cc_expiration;
    }

    public String getCc_cvv() {
        return cc_cvv;
    }

    public void setCc_cvv(String cc_cvv) {
        this.cc_cvv = cc_cvv;
    }

    public Date getPlaced_at() {
        return placed_at;
    }

    public void setPlaced_at(Date placed_at) {
        this.placed_at = placed_at;
    }
}