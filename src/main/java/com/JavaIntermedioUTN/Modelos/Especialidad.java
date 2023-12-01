package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Especialidad")
@Getter
@Setter
@NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad", nullable = false, unique = true)
    private Integer idEspecialidad;

    @Column(name = "descripcion", length = 65, nullable = false)
    private String descripcion;



    public Especialidad(Integer idEspecialidad, String descripcion) {
        this.idEspecialidad = idEspecialidad;
        this.descripcion = descripcion;
    }
}