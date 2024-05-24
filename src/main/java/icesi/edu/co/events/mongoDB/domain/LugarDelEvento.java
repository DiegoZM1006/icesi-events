package icesi.edu.co.events.mongoDB.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events_register")
public class LugarDelEvento {
    @Id
    private Integer id;
    private String name;
    private String direccion;
    private String city;

}
