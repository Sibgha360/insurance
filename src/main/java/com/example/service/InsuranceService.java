package com.example.service;

import com.example.helper.exception.ResourceNotFoundException;
import com.example.model.Insurance;
import com.example.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public float getInsurance(Float regionalClass, Float typeClass, Float annualMileageFactor) {
        float annualPremium = annualMileageFactor * typeClass * regionalClass;


        return annualPremium;
    }
}
