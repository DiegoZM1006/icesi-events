package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Programas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramasRepository extends JpaRepository<Programas, Integer> {
}
