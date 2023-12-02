package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Reporte")
@Getter
@Setter
@NoArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReporte", nullable = false, unique = true)
    private Integer idReporte;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idProblema", referencedColumnName = "idProblema")
    private Problema problema;


    @Column(name = "descripcionReporte", length = 400, nullable = false, unique = true)
    private String descripcionReporte;

    public Reporte(Integer idReporte, Problema problema, String descripcionReporte) {
        this.idReporte = idReporte;
        this.problema = problema;
        this.descripcionReporte = descripcionReporte;
    }

}

