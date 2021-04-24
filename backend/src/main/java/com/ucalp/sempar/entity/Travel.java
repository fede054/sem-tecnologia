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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "viaje")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viaje_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "servicio_id")
    private Service service;

    @OneToOne
    @JoinColumn(name = "unidad_id")
    private Unit unit;

    @Column(name = "fecha_salida_efectiva")
    private LocalDate effectiveOutDate;

    @Column(name = "observaciones")
    private String observations;

    @ManyToMany()
    @JoinTable(
            name = "viaje_chofer",
            joinColumns = @JoinColumn(name = "viaje_id"),
            inverseJoinColumns = @JoinColumn(name = "CUIL"))
    private List<Driver> drivers;

}
