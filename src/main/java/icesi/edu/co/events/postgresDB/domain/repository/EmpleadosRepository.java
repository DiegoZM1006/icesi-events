package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

    List<Empleados> findAll();

    Optional<Empleados> findById(Integer id);

    boolean existsById(Integer id);
    
}
