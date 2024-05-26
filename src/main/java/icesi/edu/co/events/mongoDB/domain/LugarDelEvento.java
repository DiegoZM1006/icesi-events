package icesi.edu.co.events.mongoDB.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LugarDelEvento {

    private String name;
    private String direccion;
    private String city;


    public LugarDelEvento() {
    }

    public LugarDelEvento(String name, String direccion, String city) {
        this.name = name;
        this.direccion = direccion;
        this.city = city;
    }
}
