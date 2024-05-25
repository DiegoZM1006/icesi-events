package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipos_empleado", schema = "eventos")
public class TipoEmpleado {
    @Id
    @Column(name = "nombre")
    private String nombre;

    // Getters and Setters
    // equals and hashCode
}
