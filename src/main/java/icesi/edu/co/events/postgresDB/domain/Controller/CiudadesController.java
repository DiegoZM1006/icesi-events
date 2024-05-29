package icesi.edu.co.events.postgresDB.domain.Controller;


import icesi.edu.co.events.postgresDB.domain.Ciudades;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.repository.CiudadesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ciudades")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class CiudadesController {

    @Autowired
    CiudadesRepository ciudadesRepository;

    @GetMapping(value = "getCiudades")
    public ResponseEntity<?> getCiudades(){
        List<Ciudades> ciudades = ciudadesRepository.findAll();
        return  new ResponseEntity<>(ciudades, HttpStatus.OK);
    }

    @GetMapping(value = "getCiudad/{id}")
    public ResponseEntity<?> getCiudad(@PathVariable Integer id){
        Optional<Ciudades> ciudad = ciudadesRepository.findById(id);
        return  new ResponseEntity<>(ciudad, HttpStatus.OK);
    }
}
