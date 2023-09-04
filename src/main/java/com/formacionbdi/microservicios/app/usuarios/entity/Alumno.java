package com.formacionbdi.microservicios.app.usuarios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP) //AAAA/mm/dd
    private Date createAt;

    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }
}
