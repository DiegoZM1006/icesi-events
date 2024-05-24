package icesi.edu.co.events.postgresDB.domain;

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
@Table(name = "empleados", schema = "eventos")
public class Empleados {
    @Id
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "tipo_contratacion", nullable = false)
    private TipoContratacion tipoContratacion;

    @ManyToOne
    @JoinColumn(name = "tipo_empleado", nullable = false)
    private TipoEmpleado tipoEmpleado;

    @ManyToOne
    @JoinColumn(name = "cod_facultad", nullable = false)
    private Facultades facultades;

    @ManyToOne
    @JoinColumn(name = "codigo_sede", nullable = false)
    private Sedes sede;

    @ManyToOne
    @JoinColumn(name = "lugar_nacimiento", nullable = false)
    private Ciudades lugarNacimiento;

}
