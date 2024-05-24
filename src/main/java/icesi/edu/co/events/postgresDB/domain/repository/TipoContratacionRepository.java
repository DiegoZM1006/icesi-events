package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.TipoContratacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContratacionRepository extends JpaRepository<TipoContratacion, Integer> {
}
