package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ciudades", schema = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(name = "cod_dpto", nullable = false)
    private Integer codigoDepartamento;

    @ManyToOne
    @JoinColumn(name = "cod_dpto", insertable = false, updatable = false)
    private Departamentos departamento;
}

