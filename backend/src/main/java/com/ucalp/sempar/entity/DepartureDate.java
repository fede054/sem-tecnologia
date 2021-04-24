package com.ucalp.sempar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "fecha_partida")
public class DepartureDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fecha_partida_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "dia_id")
    private Day day;

    @Column(name = "hora_partida")
    private LocalTime departureTime;

    @OneToMany(mappedBy = "departureDate")
    private List<Service> services;

}
