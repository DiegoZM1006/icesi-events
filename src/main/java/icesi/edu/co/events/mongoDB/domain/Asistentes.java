package icesi.edu.co.events.mongoDB.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Asistentes {

    @Id
    private Integer id;
    private String identificador;
    private String nombreUsuario;
    private String nombreCompleto;
    private String tipoRelacion;
    private String email;



    public Asistentes() {
    }

    public Asistentes(Integer id, String identificador, String nombreUsuario, String nombreCompleto, String tipoRelacion, String email) {
        this.id = id;
        this.identificador = identificador;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.tipoRelacion = tipoRelacion;
        this.email = email;
    }
}
