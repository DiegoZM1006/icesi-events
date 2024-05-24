package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Departamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer> {
}
