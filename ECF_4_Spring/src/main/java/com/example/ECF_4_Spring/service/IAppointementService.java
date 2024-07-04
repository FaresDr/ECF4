package com.example.ECF_4_Spring.service;

import com.example.ECF_4_Spring.entity.Appointement;
import com.example.ECF_4_Spring.entity.JobOffer;

import java.util.List;

public interface IAppointementService {
    List<Appointement> findAll();
    Appointement findById(Long id);

    Appointement save(Appointement appointement);
    Appointement update(Appointement appointement);
    void delete(Appointement appointement);
}
