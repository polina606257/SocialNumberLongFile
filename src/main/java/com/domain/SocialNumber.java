package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SocialNumber {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;

    private String socialNumber;

    private Double price;

    public SocialNumber(String socialNumber, Double price) {
        this.socialNumber = socialNumber;
        this.price = price;
    }

    public SocialNumber() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
