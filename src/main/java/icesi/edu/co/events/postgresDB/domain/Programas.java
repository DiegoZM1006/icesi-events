package icesi.edu.co.events.postgresDB.domain;

import icesi.edu.co.events.postgresDB.domain.Areas;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "programas", schema = "eventos")
@Data
@NoArgsConstructor
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(name = "codigo_area", nullable = false)
    private Integer codigoArea;

    @ManyToOne
    @JoinColumn(name = "codigo_area", insertable = false, updatable = false)
    private Areas area;
}
