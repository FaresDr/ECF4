package com.example.ECF_4_Spring.service;

import com.example.ECF_4_Spring.entity.JobOffer;

import java.util.List;

public interface IJobOfferService {
    List<JobOffer> findAll();
    JobOffer findById(Long id);

    JobOffer save(JobOffer jobOffer);
    JobOffer update(JobOffer jobOffer);
    void delete(JobOffer jobOffer);
}
