package com.JavaIntermedioUTN;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SistemaDeReportesApplication {



    public static void main(String[] args) {
        SpringApplication.run(SistemaDeReportesApplication.class, args);

       /* ConectorMySQL conectorMySQL =new ConectorMySQL();
        ServicioDeReportes servicioDeReportes = new ServicioDeReportes(conectorMySQL);

        Tecnico tecnico = servicioDeReportes.tecnicoConMasIncidentesResueltos(365);
        Tecnico tecnico2 = servicioDeReportes.tecnicoConMasIncidentesPorEspecialidad(900,55);
        Tecnico tecnico3 = servicioDeReportes.tecnicoMasRapidoIncidentes();
        System.out.println(tecnico2);
        System.out.println(tecnico);
        System.out.println(tecnico3);*/

    }



}
