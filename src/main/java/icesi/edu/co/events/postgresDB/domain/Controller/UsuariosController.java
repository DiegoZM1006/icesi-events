package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;

    @PostMapping("{nombre}/{password}")
    public boolean validateUser(@PathVariable String nombre, @PathVariable String password){

        Usuarios usuario1 = usuariosRepository.findByNombreUsuarioAndPassword(nombre, password);
        if (usuario1 == null){
            return false;
        }else {
            return true;
        }
    }

    @GetMapping(value = "getUsers")
    public List<Usuarios> getUsers(){
        return usuariosRepository.findAll();
    }
}
