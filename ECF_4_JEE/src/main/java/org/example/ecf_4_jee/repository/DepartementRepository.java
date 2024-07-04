package org.example.ecf_4_jee.repository;

import org.example.ecf_4_jee.model.Departement;
import org.hibernate.Session;

import java.util.List;

public class DepartementRepository extends Repository<Departement>{
    public DepartementRepository(Session session) {
        super(session);
    }

    @Override
    Departement findById(int id) {
         return (Departement) _session.get(Departement.class,id);
    }

    @Override
    List<Departement> findAll() {
        return _session.createQuery("from Departement ").list();
    }
}
