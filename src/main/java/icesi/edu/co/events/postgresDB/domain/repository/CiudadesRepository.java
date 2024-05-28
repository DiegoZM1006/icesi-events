package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer> {

    List<Ciudades> findAll();
}
