package com.JavaIntermedioUTN.SistemaDeReportes;

import com.JavaIntermedioUTN.Modelos.Caso;
import com.JavaIntermedioUTN.Modelos.Especialidad;
import com.JavaIntermedioUTN.Modelos.Tecnico;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ServicioDeReportes {
    @Autowired
    private ConectorMySQL conector;

    public ServicioDeReportes(ConectorMySQL conector) {
        this.conector = conector;
    }

    //Técnico con más incidentes resueltos en los últimos N días
    public Tecnico tecnicoConMasIncidentesResueltos(Integer cantidadDias) {

        List<Caso> casos = conector.getAll("Caso");
        Map<Tecnico, List<Caso>> tecnicosQueResolvieron = casos.stream()
                .filter(caso -> caso.getCierreTicket().after(DateTime.now().minusDays(cantidadDias).toDate()))
                .collect(Collectors.groupingBy(Caso::getTecnicoQueResolvio));

        Tecnico tecnicoConMasIncidentes = null;
        int maxIncidentes = 0;

        for (Map.Entry<Tecnico, List<Caso>> entry : tecnicosQueResolvieron.entrySet()) {
            int incidentesResueltos = entry.getValue().size();
            if (incidentesResueltos > maxIncidentes) {
                maxIncidentes = incidentesResueltos;
                tecnicoConMasIncidentes = entry.getKey();
            }
        }

        return tecnicoConMasIncidentes;
    }

    //Técnico con más incidentes resueltos de una determinada especialidad en los últimos N días

    public Tecnico tecnicoConMasIncidentesPorEspecialidad(Integer cantidadDias, Integer especialidad) {

        List<Caso> casos = conector.getAll("Caso");
        Map<Tecnico, List<Caso>> tecnicosQueResolvieron = casos.stream()
                .filter(caso -> caso.getCierreTicket().after(DateTime.now().minusDays(cantidadDias).toDate()))
                .filter(caso -> caso.getReporte().getProblema().getEspecialidades().stream().map(Especialidad::getIdEspecialidad).toList().contains(especialidad))
                .collect(Collectors.groupingBy(Caso::getTecnicoQueResolvio));


        Tecnico tecnicoConMasIncidentes = null;
        int maxIncidentes = 0;

        for (Map.Entry<Tecnico, List<Caso>> entry : tecnicosQueResolvieron.entrySet()) {
            int incidentesResueltos = entry.getValue().size();
            if (incidentesResueltos > maxIncidentes) {
                maxIncidentes = incidentesResueltos;
                tecnicoConMasIncidentes = entry.getKey();
            }
        }

        return tecnicoConMasIncidentes;
    }


    //Quién fue el técnico que más rápido resolvió los incidentes

    public Tecnico tecnicoMasRapidoIncidentes() {

        List<Caso> casos = conector.getAll("Caso");

       Optional<Caso> casoMasRapido = casos.stream()
                .min((caso1, caso2) ->Integer.compare(tiempoDeResolucion(caso1),tiempoDeResolucion(caso2)));



        return casoMasRapido.map(Caso::getTecnicoQueResolvio).get();


    }

    private Integer tiempoDeResolucion(Caso caso) {
        return
                Days.daysBetween(new DateTime(caso.getCierreTicket()), new DateTime(caso.getAperturaTicket())).getDays();

    }

}


