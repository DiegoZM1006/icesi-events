package icesi.edu.co.events.postgresDB.domain.Controller;


import icesi.edu.co.events.postgresDB.domain.Ciudades;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.repository.CiudadesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
