package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tipo_contratacion", schema = "eventos")
@Data
@NoArgsConstructor
public class TipoContratacion {

    @Id
    @Column(nullable = false, length = 30)
    private String nombre;
}
