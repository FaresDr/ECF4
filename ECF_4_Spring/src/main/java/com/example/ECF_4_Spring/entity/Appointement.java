package com.example.ECF_4_Spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointement")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Appointement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NameOfClient;
    private String NameOfChief;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "id_offer")
    private JobOffer jobOffer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name="id_candidat")
    private User user;

    @Override
    public String toString() {
        return "Appointement{" +
                "id=" + id +
                ", NameOfClient='" + NameOfClient + '\'' +
                ", NameOfChief='" + NameOfChief + '\'' +
                ", date=" + date +
                ", jobOffer=" + jobOffer +
                ", user=" + user +
                '}';
    }
}
