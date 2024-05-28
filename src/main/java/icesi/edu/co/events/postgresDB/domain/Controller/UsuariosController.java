package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Empleados;
import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.EmpleadosRepository;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class UsuariosController {

    @Autowired
    private final UsuariosRepository usuariosRepository;

    @Autowired
    private final EmpleadosRepository empleadosRepository;

    @PostMapping("{nombre}/{password}")
    public Usuarios validateUser(@PathVariable String nombre, @PathVariable String password){

        Usuarios usuario1 = usuariosRepository.findByNombreUsuarioAndPassword(nombre, password);
        if (usuario1 == null){
            return null;
        }else {
            return usuario1;
        }
    }

    @GetMapping(value = "getUsers")
    public List<Usuarios> getUsers(){
        return usuariosRepository.findAll();
    }

    @PostMapping("saveUsuario")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario) {
        Usuarios usuarioToSave = new Usuarios();
        usuarioToSave.setId(usuario.getId());
        usuarioToSave.setPassword(usuario.getPassword());
        usuarioToSave.setNombreUsuario(usuario.getNombreUsuario());
        usuarioToSave.setNombre(usuario.getNombre());
        usuarioToSave.setCiudad(usuario.getCiudad());
        usuarioToSave.setEmail(usuario.getEmail());
        usuarioToSave.setTipoRelacion(usuario.getTipoRelacion());
        usuarioToSave.setRol(usuario.getRol());
        usuariosRepository.save(usuarioToSave);
        return ResponseEntity.ok(usuarioToSave);
    }

    @PostMapping("saveUsuarioEmpleado/{nombreUsuario}/{password}")
    public ResponseEntity<?> saveUsuarioEmpleado(@PathVariable String nombreUsuario, @PathVariable String password, @RequestBody Empleados empleado) {

        Usuarios usuario = new Usuarios();
        usuario.setId(empleado.getIdentificacion());
        usuario.setNombre(empleado.getNombres());
        usuario.setEmail(empleado.getEmail());
        usuario.setCiudad(empleado.getLugarNacimiento());
        usuario.setTipoRelacion(empleado.getTipoEmpleado().getNombre());
        usuario.setRol("VIEWER");
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuariosRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

}
