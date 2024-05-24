package icesi.edu.co.events.mongoDB.dto;

public class LugarDelEventoDTO {

    private String name;
    private String direccion;
    private String city;

    public LugarDelEventoDTO() {
    }

    public LugarDelEventoDTO(String name, String direccion, String city) {
        this.name = name;
        this.direccion = direccion;
        this.city = city;
    }
}
