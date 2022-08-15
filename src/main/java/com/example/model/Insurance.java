package com.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_calculation")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "insurance_calculation_id")
    private Integer InsuranceCalculationId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "annual_premium_insurance")
    private Float annualPremiumInsurance;

    @Column(name = "regional_class")
    Float regionalClass;

    @Column(name = "type_class")
    Float typeClass;

    @Column(name = "annual_mileage_factor")
    Float annualMileageFactor;

    @Column(name = "car_manufacturer")
    String carManufacturer;

    @Column(name = "postal_code")
    String postalCode;

    @Column(name = "mileage")
    String mileage;

    public Insurance(Float annualPremiumInsurance, Float regionalClass, Float typeClass, Float annualMileageFactor) {
        this.annualPremiumInsurance = annualPremiumInsurance;
        this.regionalClass = regionalClass;
        this.typeClass = typeClass;
        this.annualMileageFactor = annualMileageFactor;
        this.carManufacturer = carManufacturer;
        this.postalCode = postalCode;
        this.mileage = mileage;
        this.creationTime = LocalDateTime.now();
    }

    public Integer getInsuranceCalculationId() {
        return InsuranceCalculationId;
    }

    public void setInsuranceCalculationId(Integer insuranceCalculationId) {
        InsuranceCalculationId = insuranceCalculationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Float getAnnualPremiumInsurance() {
        return annualPremiumInsurance;
    }

    public void setAnnualPremiumInsurance(Float annualPremiumInsurance) {
        this.annualPremiumInsurance = annualPremiumInsurance;
    }

    public Float getRegionalClass() {
        return regionalClass;
    }

    public void setRegionalClass(Float regionalClass) {
        this.regionalClass = regionalClass;
    }

    public Float getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(Float typeClass) {
        this.typeClass = typeClass;
    }

    public Float getAnnualMileageFactor() {
        return annualMileageFactor;
    }

    public void setAnnualMileageFactor(Float annualMileageFactor) {
        this.annualMileageFactor = annualMileageFactor;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
}