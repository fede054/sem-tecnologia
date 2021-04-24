package com.ucalp.sempar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chofer")
public class Driver {

    @Id
    @Column(name = "CUIL")
    private Long cuil;

    @Column(name = "apellido")
    private String surname;

    @Column(name = "nombre")
    private String name;

    @Column(name = "domilicio")
    private String domicile;

    @Column(name = "telefono_1")
    private String firstPhoneNumber;

    @Column(name = "telefono_2")
    private String secondPhoneNumber;

    @Column(name = "fecha_de_nacimiento")
    private LocalDate birthDate;

    @Column(name = "fecha_de_ingreso")
    private LocalDate admissionDate;

    @Column(name = "fecha_de_baja")
    private LocalDate dischargeDate;

    @Column(name = "motivo_de_baja")
    private String dischargeReason;

    @Column(name = "fecha_de_vencimiento_de_carnet")
    private LocalDate cardExpirationDate;

    @ManyToMany(mappedBy = "drivers")
    private List<Travel> travels;

}
