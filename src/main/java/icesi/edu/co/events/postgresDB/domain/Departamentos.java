package icesi.edu.co.events.postgresDB.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamentos", schema = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(name = "cod_pais", nullable = false)
    private Integer codigoPais;

    @ManyToOne
    @JoinColumn(name = "cod_pais", insertable = false, updatable = false)
    private Paises pais;
}
