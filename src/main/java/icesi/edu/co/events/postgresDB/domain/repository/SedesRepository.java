package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Sedes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedesRepository extends JpaRepository<Sedes, Integer> {
}
