package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios", schema = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    @Id
    private Integer id;
    private String nombre;
    private String password;
    private String rol;
}
