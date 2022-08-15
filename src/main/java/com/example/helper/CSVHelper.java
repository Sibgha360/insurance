package com.example.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.util.NumberUtils;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"REGION1", "REGION3", "REGION4", "POSTLEITZAHL", "LOCATION"};
    public static String preDefinedDateFormat = "MM/dd/yyyy";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(preDefinedDateFormat).withLocale(Locale.GERMANY);

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Postcode> csvToPostcode(InputStream is) throws Exception {
        CSVParser csvParser = getCsvParser(is);

        List<Postcode> postcodes = new ArrayList<>();

        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            String state = csvRecord.get("REGION1");
            String country = csvRecord.get("REGION3");
            String city = csvRecord.get("REGION4");
            String postalCode = csvRecord.get("POSTLEITZAHL");
            String town = csvRecord.get("LOCATION");
            if (!validateTextParam(state) && !validateTextParam(country) && !validateTextParam(city) && !validateTextParam(postalCode) && !validateTextParam(town)) {
                System.out.println("Skipping entry. parameter missing");
                continue;
            }


            Postcode postcode = new Postcode(state, country, city, postalCode, town);
            postcodes.add(postcode);
        }
        return postcodes;

    }

    private static CSVParser getCsvParser(InputStream is) throws IOException {
        CSVParser csvParser = null;

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        return csvParser;
    }

    public static boolean validateTextParam(String param) {
        if (param == null || param.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean validateFloatParam(String param) {
        if (param == null || param.isEmpty()) {
            return false;
        }

        try {
            NumberUtils.parseNumber(param, Float.class);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private static GenderEnum getGenderEnum(String gender) {
        GenderEnum genderEnum;

        if (gender.equals("m")) {
            genderEnum = GenderEnum.Male;
        } else if (gender.equals("f")) {
            genderEnum = GenderEnum.Female;
        } else {
            genderEnum = GenderEnum.Unspecified;
        }
        return genderEnum;
    }
}
