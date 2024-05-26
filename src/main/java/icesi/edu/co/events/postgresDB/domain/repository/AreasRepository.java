package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Areas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreasRepository extends JpaRepository<Areas, Integer> {
    List<Areas> findAll();

    List<Areas> findAreasByCodigoFacultad(int codigoFacultad);
}
