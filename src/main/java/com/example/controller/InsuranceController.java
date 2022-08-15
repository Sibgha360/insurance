package com.example.controller;

import com.example.helper.CSVHelper;
import com.example.helper.Metadata;
import com.example.helper.exception.BadRequestException;
import com.example.helper.message.ResponseMessage;
import com.example.model.Insurance;
import com.example.model.Postcode;
import com.example.repository.InsuranceRepository;
import com.example.repository.PostcodeRepository;
import com.example.service.CSVService;
import com.example.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/csv")
public class InsuranceController {

    @Autowired
    CSVService uploadService;

    @Autowired
    InsuranceRepository insuranceRepository1;

    @Autowired
    PostcodeRepository postcodeRepository;

    @Autowired
    InsuranceService insuranceService;

    @PostMapping("/calculateInsurance")
    public ResponseEntity<ResponseMessage> calculateInsurance(@RequestParam("mileage") String mileage, @RequestParam("carManufacturer") String carManufacturer, @RequestParam("postalCode") String postalCode) throws Exception {
        if (!CSVHelper.validateTextParam(carManufacturer) && !CSVHelper.validateTextParam(mileage) && !CSVHelper.validateTextParam(postalCode)) {
            System.out.println("Invalid parameter");
            throw new BadRequestException();
        }

        //get state for the given postal code
        Postcode postcode = postcodeRepository.findByPostalCode(postalCode);

        Float regionalClass = Metadata.getRegionalClass(postcode.getFederalState());
        Float typeClass = Metadata.getTypeClass(carManufacturer);
        Float annualMileageFactor = Metadata.getAnnualMileageFactor(mileage);

        float insuranceAnnualPremium = insuranceService.getInsurance(regionalClass, typeClass, annualMileageFactor);

        Insurance insurance = new Insurance(insuranceAnnualPremium, regionalClass, typeClass, annualMileageFactor);
        insurance.setCarManufacturer(carManufacturer);
        insurance.setMileage(mileage);
        insurance.setPostalCode(postalCode);
        insurance.setUserId("dummy");

        insuranceRepository1.save(insurance);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(insurance.getAnnualPremiumInsurance().toString()));
    }
}
