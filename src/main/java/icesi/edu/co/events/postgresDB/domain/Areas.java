package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "areas", schema = "eventos")
@Data
@NoArgsConstructor
public class Areas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 40)
    private String nombre;

    @Column(name = "codigo_facultad", nullable = false)
    private Integer codigoFacultad;

    @Column(name = "id_coordinador", nullable = false, length = 15)
    private String idCoordinador;

    @ManyToOne
    @JoinColumn(name = "codigo_facultad", insertable = false, updatable = false)
    private Facultades facultades;

    @ManyToOne
    @JoinColumn(name = "id_coordinador", insertable = false, updatable = false)
    private Empleados coordinador;
}

