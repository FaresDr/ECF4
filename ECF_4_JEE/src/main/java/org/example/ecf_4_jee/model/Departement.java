package org.example.ecf_4_jee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Job> jobs;
}
