package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Tecnico")
@Getter
@Setter
@NoArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTecnico", nullable = false, unique = true)
    private Integer idTecnico;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "EspecialidadPorTecnico", joinColumns = @JoinColumn(name = "idTecnico"), inverseJoinColumns = @JoinColumn(name = "idEspecialidad"))
    private Set<Especialidad> especialidades;


    @Column(name = "nombreApellido", length = 80, unique = true)
    private String nombreApellido;

    @Column(name = "telefono", length = 45, unique = true)
    private String telefono;

    @Column(name = "emailTecnico", length = 45, unique = true)
    private String emailTecnico;


    public Tecnico(Integer idTecnico, Set<Especialidad> especialidades, String nombreApellido, String telefono, String emailTecnico) {
        this.idTecnico = idTecnico;
        this.especialidades = especialidades;
        this.nombreApellido = nombreApellido;
        this.telefono = telefono;
        this.emailTecnico = emailTecnico;
    }
}