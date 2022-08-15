package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "postcode")
public class Postcode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postcode_id")
    private Integer postcodeId;

    @Column(name = "federal_state")
    private String federalState;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    String city;

    @Column(name = "postal_code")
    String postalCode;

    @Column(name = "town")
    String town;

    public Postcode(String federalState, String country, String city, String postalCode, String town) {
        this.federalState = federalState;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.town = town;
    }

    public Integer getPostcodeId() {
        return postcodeId;
    }

    public void setPostcodeId(Integer postcodeId) {
        this.postcodeId = postcodeId;
    }

    public String getFederalState() {
        return federalState;
    }

    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Postcode{" +
                "postcodeId=" + postcodeId +
                ", federalState='" + federalState + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}