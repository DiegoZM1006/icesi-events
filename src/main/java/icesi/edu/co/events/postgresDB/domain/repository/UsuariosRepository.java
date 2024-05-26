package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    Optional<Usuarios> findById(String id);
    Usuarios findByNombreUsuarioAndPassword(String nombre, String password);

}
