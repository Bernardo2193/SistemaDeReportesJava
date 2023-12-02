package com.JavaIntermedioUTN.Controladores;

import com.JavaIntermedioUTN.Modelos.Cliente;
import com.JavaIntermedioUTN.Modelos.Tecnico;
import com.JavaIntermedioUTN.SistemaDeReportes.ServicioDeReportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")

public class ControladorDeTecnicos {


    @Autowired
    private ServicioDeReportes servicioDeReportes;


    @GetMapping("/masIncidentesResueltos")
    public Tecnico tecnicoConMasIncidentesResueltos(@RequestParam Integer dias){

        return servicioDeReportes.tecnicoConMasIncidentesResueltos(dias);
    }


    @GetMapping("/masIncidentesPorEspecialidad")
    public Tecnico tecnicoConMasIncidentesPorEspecialidad(@RequestParam Integer dias, @RequestParam Integer especialidad){

        return servicioDeReportes.tecnicoConMasIncidentesPorEspecialidad(dias,especialidad);
    }

    @GetMapping("/masRapidoIncidentesResueltos")
    public Tecnico tecnicoMasRapidoIncidentes(){

        return servicioDeReportes.tecnicoMasRapidoIncidentes();
    }


}
