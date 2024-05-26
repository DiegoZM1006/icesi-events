package icesi.edu.co.events.postgresDB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios", schema = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    @Id
    @Column(nullable = false, name = "id")
    private String id;

    @Column(nullable = false, length = 40, name = "password")
    private String password;

    @Column(nullable = false, length = 40, name = "rol")
    private String rol;

    @Column(nullable = false, length = 40, name = "nombreusuario")
    private String nombreUsuario;

    @Column(nullable = false, length = 40, name = "nombre")
    private String nombre;

    @Column(nullable = false, length = 40, name = "tiporelacion")
    private String tipoRelacion;

    @Column(nullable = false, length = 40, name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "ciudad", nullable = false)
    private Ciudades ciudad;
}