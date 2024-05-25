package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
public class Asistentes {

    @Id
    private Integer id;
    private String identificador;
    private String nombreUsuario;
    private String nombreCompleto;
    private String tipoRelacion;
    private String email;

    private Ciudades ciudad;


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
