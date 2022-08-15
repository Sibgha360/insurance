package com.example.repository;

import com.example.model.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PostcodeRepository extends MongoRepository<Postcode, Long> {
    Postcode findByPostalCode(String postalCode);
}