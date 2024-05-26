package icesi.edu.co.events.postgresDB.domain.repository;

import icesi.edu.co.events.postgresDB.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    Usuarios findById(Integer id);
    Usuarios findByNombreUsuarioAndPassword(String nombre, String password);

}
