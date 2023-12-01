package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Servicio")
@Getter
@Setter
@NoArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio", nullable = false, unique = true)
    private Integer idServicio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TecnicosPorServicio", joinColumns = @JoinColumn(name = "idServicio"), inverseJoinColumns = @JoinColumn(name = "idTecnico"))
    private Set<Tecnico> tecnicos;


    @Column(name = "areaServicio", length = 100, unique = true)
    private String areaServicio;


    public Servicio(Integer idServicio, Set<Tecnico> tecnicos, String areaServicio) {
        this.idServicio = idServicio;
        this.tecnicos = tecnicos;
        this.areaServicio = areaServicio;
    }
}