package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipos_empleado", schema = "eventos")
public class TipoEmpleado {
    @Id
    @Column(name = "nombre")
    private String nombre;

    // Getters and Setters
    // equals and hashCode
}
