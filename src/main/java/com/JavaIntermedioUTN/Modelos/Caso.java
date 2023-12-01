package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Caso")
@Getter
@Setter
@NoArgsConstructor
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaso", nullable = false, unique = true)
    private Integer idCaso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idReporte",referencedColumnName = "idReporte")
    private Reporte reporte;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idServicio",referencedColumnName = "idServicio")
    private Servicio servicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuitCliente",referencedColumnName = "cuitCliente")
    private Cliente cliente;

    //Agregue  esta relacion caso-tecnico
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTecnicoQueResolvio",referencedColumnName = "idTecnico")
    private Tecnico tecnicoQueResolvio;

    @Column(name = "aperturaTicket", nullable = false, unique = true)
    private Date aperturaTicket;

    @Column(name = "descripcion", nullable = false, length = 400, unique = true)
    private String descripcion;

    @Column(name = "veredictoTecnico", length = 400, unique = true)
    private String veredictoTecnico;


    @Column(name = "cierreTicket",unique = true)
    private Date cierreTicket;


    public Caso(Integer idCaso, Reporte reporte, Servicio servicio, Cliente cliente, Date aperturaTicket, String descripcion, String veredictoTecnico, Date cierreTicket) {
        this.idCaso = idCaso;
        this.reporte = reporte;
        this.servicio = servicio;
        this.cliente = cliente;
        this.aperturaTicket = aperturaTicket;
        this.descripcion = descripcion;
        this.veredictoTecnico = veredictoTecnico;
        this.cierreTicket = cierreTicket;
    }
}
