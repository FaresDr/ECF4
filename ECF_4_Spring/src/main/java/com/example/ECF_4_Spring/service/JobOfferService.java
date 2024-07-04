package com.example.ECF_4_Spring.service;

import com.example.ECF_4_Spring.entity.JobOffer;
import com.example.ECF_4_Spring.repository.JobOfferRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobOfferService implements IJobOfferService {
    private final JobOfferRepository jobOfferRepository;
    @Autowired
    public JobOfferService(JobOfferRepository jobOfferRepository) {this.jobOfferRepository = jobOfferRepository;}

    @Override
    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    @Override
    public JobOffer findById(Long id) {
        return jobOfferRepository.findById(id).orElse(null);
    }

    @Override
    public JobOffer save(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public JobOffer update(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public void delete(JobOffer jobOffer) {
        jobOfferRepository.delete(jobOffer);
    }
}
