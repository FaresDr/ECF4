package com.example.ECF_4_Spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "joboffer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String jobDescription;
    private LocalDateTime date;
    private double wage;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "candidat_appointement", joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "candidat_id"))
    private List<User> users;
    @OneToMany(mappedBy = "jobOffer", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Appointement> appointements;

    public void add(User user){
        users.add(user);
    }
}
