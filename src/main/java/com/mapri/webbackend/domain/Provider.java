package com.mapri.webbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provider")
public class Provider extends Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
}
