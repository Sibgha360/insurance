package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Insurance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsuranceRepository extends MongoRepository<Insurance, Long> {
}
