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
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reparacion")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reparacion_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "unidad_id")
    private Unit unit;

    @Column(name = "tiempo_reparacion_dias")
    private Integer repairTime;

    @Column(name = "detalle")
    private String details;

}
