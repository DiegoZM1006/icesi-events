package icesi.edu.co.events.mongoDB.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "events_register")
public class Eventos {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;

    private LugarDelEvento lugarDelEvento;

    private  List<Asistentes> asistentes;

    public Eventos() {
    }

    public Eventos(Integer id, String titulo, String descripcion, LocalDate fecha, LugarDelEvento lugarDelEvento, List<Asistentes> asistentes) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.lugarDelEvento = lugarDelEvento;
        this.asistentes = asistentes;
    }
}