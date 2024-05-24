package icesi.edu.co.events.mongoDB.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection =  "comentarios")
public class Comentarios {

    @Id
    private Integer id;
    private String username;
    private String comentario;

}
