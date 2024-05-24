package icesi.edu.co.events.mongoDB.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asistentes")
public class Asistentes {
    @Id
    private Integer id;
    private String identificador;
    private String nombreUsuario;
    private String nombreCompleto;
    private String tipoRelacion;
    private String email;

}
