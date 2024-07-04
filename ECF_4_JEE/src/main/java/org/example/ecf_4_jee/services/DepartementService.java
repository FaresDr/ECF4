package org.example.ecf_4_jee.services;

import org.example.ecf_4_jee.model.Departement;
import org.example.ecf_4_jee.repository.DepartementRepository;

public class DepartementService {

    DepartementRepository departementRepository;

    public void create(Departement departement){
        departementRepository.create(departement);
    }
}
