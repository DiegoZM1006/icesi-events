package icesi.edu.co.events.mongoDB.domain;


import jakarta.persistence.Embedded;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "events_register")
public class Events {
    @Id
    private Integer id;
    private String titulo;
    private String descripción;
    private LocalDate fecha;

    @Embedded
    private LugarDelEvento lugarDelEvento;

    @Embedded
    private  List<Asistentes> asistentes;
}