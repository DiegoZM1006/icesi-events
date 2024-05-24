package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "paises", schema = "eventos")
public class Paises {
    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre")
    private String nombre;

}

