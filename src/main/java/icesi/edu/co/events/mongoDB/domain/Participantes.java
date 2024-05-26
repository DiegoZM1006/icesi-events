package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Participantes {

    @Id
    private String id;
    private String rol;
    private String nombreUsuario;
    private String nombreCompleto;
    private String tipoRelacion;
    private String email;

    private Ciudades ciudad;


    public Participantes() {
    }

    public Participantes(String id, String nombreUsuario, String nombreCompleto, String tipoRelacion, String email) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.tipoRelacion = tipoRelacion;
        this.email = email;
    }
}
