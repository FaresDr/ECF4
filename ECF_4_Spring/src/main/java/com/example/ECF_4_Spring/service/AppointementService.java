package com.example.ECF_4_Spring.service;

import com.example.ECF_4_Spring.entity.Appointement;
import com.example.ECF_4_Spring.repository.AppointementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointementService implements IAppointementService {
    private final AppointementRepository appointementRepository;

    @Autowired
    public AppointementService(AppointementRepository appointementRepository) {
        this.appointementRepository = appointementRepository;
    }

    @Override
    public List<Appointement> findAll() {
        return appointementRepository.findAll();
    }

    @Override
    public Appointement findById(Long id) {
        return appointementRepository.findById(id).orElse(null);
    }

    @Override
    public Appointement save(Appointement appointement) {
        return appointementRepository.save(appointement);
    }

    @Override
    public Appointement update(Appointement appointement) {
        return appointementRepository.save(appointement);
    }

    @Override
    public void delete(Appointement appointement) {appointementRepository.delete(appointement);
    }
}
