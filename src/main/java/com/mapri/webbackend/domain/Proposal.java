package com.mapri.webbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @OneToOne
    @JoinColumn(name = "id_provider")
    Provider provider;

    @OneToOne
    @JoinColumn(name = "budget")
    Budget budget;

    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;

    @Column(name = "choosed")
    Boolean choosed;

    @Column(name = "deliveryTime")
    int deliveryTime;
}
