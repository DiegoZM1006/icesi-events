package icesi.edu.co.events.mongoDB.dto;

import icesi.edu.co.events.mongoDB.domain.Asistentes;
import icesi.edu.co.events.mongoDB.domain.Comentarios;
import icesi.edu.co.events.mongoDB.domain.LugarDelEvento;

import java.time.LocalDate;
import java.util.List;

public class EventsDTO {

    private String titulo;
    private String descripción;
    private LocalDate fecha;
    private String estado;

    private LugarDelEvento lugarDelEvento;

    private List<Asistentes> asistentes;

    private List<Comentarios> comentarios;

    public EventsDTO() {
    }

    public EventsDTO(String titulo, String descripción, LocalDate fecha, LugarDelEvento lugarDelEvento, List<Asistentes> asistentes, String estado, List<Comentarios> comentarios) {
        this.titulo = titulo;
        this.descripción = descripción;
        this.fecha = fecha;
        this.lugarDelEvento = lugarDelEvento;
        this.asistentes = asistentes;
        this.comentarios = comentarios;
    }
}
