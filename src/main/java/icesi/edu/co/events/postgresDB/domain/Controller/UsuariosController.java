package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;

    @PostMapping("{nombre}/{password}")
    public boolean validateUser(@PathVariable String nombre, @PathVariable String password){

        Usuarios usuario1 = usuariosRepository.findByNombreAndPassword(nombre, password);
        if (usuario1 == null){
            return false;
        }else {
            return true;
        }
    }
}
