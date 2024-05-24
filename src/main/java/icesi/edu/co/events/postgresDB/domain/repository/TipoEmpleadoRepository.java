package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.TipoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEmpleadoRepository extends JpaRepository<TipoEmpleado, Integer> {
}
