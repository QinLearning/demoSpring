package com.example.demospring02.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * taco
 * @author 
 */
@Data
public class Taco implements Serializable {
    private String id;

    private String name;

    private String taco_order;

    private String taco_order_key;

    private Date created_at;

    private static final long serialVersionUID = 1L;

}