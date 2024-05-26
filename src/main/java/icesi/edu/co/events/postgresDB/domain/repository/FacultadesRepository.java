package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Facultades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultadesRepository extends JpaRepository<Facultades, Integer> {

    List<Facultades> findAll();
}
