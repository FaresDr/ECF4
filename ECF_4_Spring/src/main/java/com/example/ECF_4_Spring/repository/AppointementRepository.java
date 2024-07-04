package com.example.ECF_4_Spring.repository;

import com.example.ECF_4_Spring.entity.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointementRepository extends JpaRepository<Appointement, Long> {
}
