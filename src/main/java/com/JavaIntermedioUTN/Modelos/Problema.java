package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Problema")
@Getter
@Setter
@NoArgsConstructor
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProblema", nullable = false, unique = true)
    private Integer idProblema;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "ProblemaPorEspecialidad",joinColumns = @JoinColumn(name = "idProblema"),inverseJoinColumns = @JoinColumn(name="idEspecialidad"))
    private Set<Especialidad> especialidades;


    @Column(name = "descripcion", length = 100, unique = true)
    private String descripcion;


    public Problema(Integer idProblema, Set<Especialidad> especialidades, String descripcion) {
        this.idProblema = idProblema;
        this.especialidades = especialidades;
        this.descripcion = descripcion;
    }
}