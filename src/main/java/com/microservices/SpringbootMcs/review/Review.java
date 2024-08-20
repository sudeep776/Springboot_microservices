package com.microservices.SpringbootMcs.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservices.SpringbootMcs.company.Company;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
