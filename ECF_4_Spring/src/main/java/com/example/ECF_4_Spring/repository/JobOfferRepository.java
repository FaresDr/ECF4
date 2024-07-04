package com.example.ECF_4_Spring.repository;

import com.example.ECF_4_Spring.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
