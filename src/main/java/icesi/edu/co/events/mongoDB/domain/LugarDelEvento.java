package icesi.edu.co.events.mongoDB.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class LugarDelEvento {
    @Id
    private Integer id;
    private String name;
    private String direccion;
    private String city;
    

    public LugarDelEvento(Integer id, String name, String direccion, String city) {
        this.id = id;
        this.name = name;
        this.direccion = direccion;
        this.city = city;
    }
}
