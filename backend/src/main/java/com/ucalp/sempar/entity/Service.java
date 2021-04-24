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
@Entity(name = "servicio")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "tipo_unidad_id")
    private UnitType unitType;

    @OneToOne
    @JoinColumn(name = "fecha_partida_id")
    private DepartureDate departureDate;

    @OneToOne
    @JoinColumn(name = "estacion_id_origen")
    private Station originStation;

    @OneToOne
    @JoinColumn(name = "estacion_id_destino")
    private Station destinationStation;

    @OneToOne(mappedBy = "service")
    private Travel travel;

}
