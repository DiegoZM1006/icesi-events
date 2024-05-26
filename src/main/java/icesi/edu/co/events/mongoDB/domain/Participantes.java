package icesi.edu.co.events.mongoDB.domain;

import icesi.edu.co.events.postgresDB.domain.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
public class Participantes {

    @Id
    private String id;
    private Usuarios usuario;
    private String role;


    public Participantes() {
    }

}
