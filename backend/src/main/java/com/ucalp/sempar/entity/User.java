package com.ucalp.sempar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_usuario")
    private String username;

    @ToString.Exclude
    @Column(name = "contrasena")
    private String password;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Log> logs;

}
