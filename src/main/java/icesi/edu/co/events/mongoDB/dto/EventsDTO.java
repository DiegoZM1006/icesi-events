package icesi.edu.co.events.mongoDB.dto;

import icesi.edu.co.events.mongoDB.domain.Asistentes;
import icesi.edu.co.events.mongoDB.domain.LugarDelEvento;

import java.time.LocalDate;
import java.util.List;

public class EventsDTO {

    private String titulo;
    private String descripción;
    private LocalDate fecha;

    private LugarDelEvento lugarDelEvento;

    private List<Asistentes> asistentes;

    public EventsDTO() {
    }

    public EventsDTO(String titulo, String descripción, LocalDate fecha, LugarDelEvento lugarDelEvento, List<Asistentes> asistentes) {
        this.titulo = titulo;
        this.descripción = descripción;
        this.fecha = fecha;
        this.lugarDelEvento = lugarDelEvento;
        this.asistentes = asistentes;
    }
}
