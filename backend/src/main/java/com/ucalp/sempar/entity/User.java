package com.ucalp.sempar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class User {

    @Id
    @Column(name = "nombre_usuario")
    private String username;

    @ToString.Exclude
    @Column(name = "contrasena")
    private String password;

}
