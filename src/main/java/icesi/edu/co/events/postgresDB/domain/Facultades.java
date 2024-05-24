package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "facultades", schema = "eventos")
public class Facultades {
    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "nro_telefono")
    private String nroTelefono;

    @OneToOne
    @JoinColumn(name = "id_decano", unique = true)
    private Empleados decano;

}
