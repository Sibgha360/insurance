package com.example.service;

import java.util.List;

import com.example.helper.CSVHelper;
import com.example.model.Postcode;
import com.example.repository.PostcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
    @Autowired
    PostcodeRepository postcodeRepository1;

    public void saveRecord(MultipartFile file) throws Exception {
        List<Postcode> postcode = CSVHelper.csvToPostcode(file.getInputStream());
        postcodeRepository1.saveAll(postcode);
    }
}
