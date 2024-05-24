package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer> {

}
