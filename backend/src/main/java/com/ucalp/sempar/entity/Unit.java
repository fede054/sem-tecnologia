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
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "unidad")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unidad_id")
    private Long id;

    @Column(name = "patente")
    private String patent;

    @Column(name = "fecha_de_patentamiento")
    private LocalDate patentDate;

    @Column(name = "cantidad_de_asientos_cama")
    private Integer bedSeatsAmount;

    @Column(name = "cantidad_de_asientos_semicama")
    private Integer semiBedSeatsAmount;

    @OneToOne
    @JoinColumn(name = "tipo_unidad_id")
    private UnitType unitType;

    @OneToMany(mappedBy = "unit")
    private List<Repair> repairs;

}
