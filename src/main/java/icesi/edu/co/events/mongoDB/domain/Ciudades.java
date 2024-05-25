package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;

@Data
public class Ciudades {

    private String nombre;
    private String departamento;
    private String pais;

    public Ciudades() {
    }

    public Ciudades(String nombre, String departamento, String pais) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.pais = pais;
    }
}


