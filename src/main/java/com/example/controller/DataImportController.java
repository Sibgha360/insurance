package com.example.controller;

import com.example.helper.exception.BadRequestException;
import com.example.model.Insurance;
import com.example.model.Postcode;
import com.example.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.CSVService;
import com.example.helper.CSVHelper;
import com.example.helper.message.ResponseMessage;

import java.util.List;

@Controller
@RequestMapping("/api/csv")
public class DataImportController {

    @Autowired
    CSVService uploadService;

    @Autowired
    InsuranceRepository insuranceRepository1;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFileBooks(@RequestParam("file") MultipartFile file) throws Exception {
        validateFileFormat(file);

        uploadService.saveRecord(file);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
    }

    private void validateFileFormat(MultipartFile file) throws BadRequestException {
        if (!CSVHelper.hasCSVFormat(file)) {
            throw new BadRequestException("Please upload a csv file!");
        }
    }
}
