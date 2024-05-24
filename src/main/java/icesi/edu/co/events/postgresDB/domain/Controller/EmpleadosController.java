package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Empleados;
import icesi.edu.co.events.postgresDB.domain.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empleados")
@RequiredArgsConstructor
public class EmpleadosController {

    private final EmpleadosRepository empleadosRepository;

    @GetMapping(value = "allEmpleados")
    public List<Empleados> getAllEmpleados(){
        List<Empleados> empleadosLista = empleadosRepository.findAll();
        return empleadosLista;
    }

}
