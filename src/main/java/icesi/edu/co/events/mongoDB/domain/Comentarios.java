package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
public class Comentarios {

    @Id
    private Integer id;
    private String username;
    private String contenido;
    private LocalDate fecha;

    public Comentarios() {
    }

    public Comentarios(Integer id, String username, String contenido, LocalDate fecha) {
        this.id = id;
        this.username = username;
        this.contenido = contenido;
        this.fecha = fecha;
    }
}
