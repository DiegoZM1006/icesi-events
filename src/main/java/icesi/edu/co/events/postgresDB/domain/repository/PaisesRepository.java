package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Paises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisesRepository extends JpaRepository<Paises, Integer> {
}
