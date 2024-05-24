package icesi.edu.co.events.mongoDB.dto;

public class AsistentesDTO {

    private String identificador;
    private String nombreUsuario;
    private String nombreCompleto;
    private String tipoRelacion;
    private String email;

    public AsistentesDTO() {
    }

    public AsistentesDTO(String identificador, String nombreUsuario, String nombreCompleto, String tipoRelacion, String email) {
        this.identificador = identificador;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.tipoRelacion = tipoRelacion;
        this.email = email;
    }
}

