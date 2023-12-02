package com.JavaIntermedioUTN.Modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "cuitCliente", nullable = false, unique = true, length = 25)
    private String cuitCliente;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "ServicioPorCliente",joinColumns = @JoinColumn(name = "cuitCliente"),inverseJoinColumns = @JoinColumn(name="idServicio"))
    private Set<Servicio> servicios;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente",fetch = FetchType.EAGER)
    private Set<Caso> casos;

    @Column(name = "razonSocial", length = 45, nullable = false)
    private String razonSocial;

    @Column(name = "emailCliente", length = 45, nullable = false)
    private String emailCliente;


    public Cliente(String cuitCliente, Set<Servicio> servicios, Set<Caso> casos, String razonSocial, String emailCliente) {
        this.cuitCliente = cuitCliente;
        this.servicios = servicios;
        this.casos = casos;
        this.razonSocial = razonSocial;
        this.emailCliente = emailCliente;
    }
}
