package icesi.edu.co.events.postgresDB.domain;

import icesi.edu.co.events.postgresDB.domain.Ciudades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sedes", schema = "eventos")
public class Sedes {
    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "cod_ciudad", nullable = false)
    private Ciudades ciudad;

}
