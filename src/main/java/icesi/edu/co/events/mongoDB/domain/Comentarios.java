package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection =  "comentarios")
public class Comentarios {

    @Id
    private Integer id;
    private String username;
    private String comentario;
    private LocalDate fecha;

    public Comentarios() {
    }

    public Comentarios(Integer id, String username, String comentario, LocalDate fecha) {
        this.id = id;
        this.username = username;
        this.comentario = comentario;
        this.fecha = fecha;
    }
}
