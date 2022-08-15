package com.example.helper;

public class Metadata {
    public static Float getRegionalClass(String federalState) {
        if (federalState.equals("Bavaria")) {
            return 0.5f;
        }
        if (federalState.equals("Hessen")) {
            return 1.0f;
        }
        if (federalState.equals("NRW")) {
            return 1.5f;
        }
        return null;
    }

    public static Float getTypeClass(String carManufacturer) {
        if (carManufacturer.equals("BMW")) {
            return 0.5f;
        }
        if (carManufacturer.equals("Audi")) {
            return 1.0f;
        }
        if (carManufacturer.equals("VW")) {
            return 1.5f;
        }

        return null;
    }

    public static Float getAnnualMileageFactor(String mileage) {
        Float mileageF = Float.valueOf(mileage);

        if (mileageF >= 0f && mileageF <= 5000f) {
            return 0.5f;
        }
        if (mileageF >= 5001f && mileageF <= 10000f) {
            return 1.0f;
        }
        if (mileageF >= 10001f && mileageF <= 20000f) {
            return 1.5f;
        }
        if (mileageF >= 20001f) {
            return 2.0f;
        }
        return null;
    }
}
