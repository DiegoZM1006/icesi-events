package icesi.edu.co.events.postgresDB.domain;

import icesi.edu.co.events.postgresDB.domain.Ciudades;
import jakarta.persistence.*;

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
