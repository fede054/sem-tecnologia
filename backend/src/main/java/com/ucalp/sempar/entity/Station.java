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
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "estacion")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estacion_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "localidad_id")
    private Locality locality;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phoneNumber;

    @OneToMany(mappedBy = "originStation")
    private List<Service> originStationServices;

    @OneToMany(mappedBy = "destinationStation")
    private List<Service> destinationStationServices;

}
