package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Areas;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.Programas;
import icesi.edu.co.events.postgresDB.domain.repository.AreasRepository;
import icesi.edu.co.events.postgresDB.domain.repository.ProgramasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("programas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ProgramasController {

    private final ProgramasRepository programasRepository;
    private final AreasRepository areasRepository;

    @GetMapping(value = "getProgramas/{id}")
    public ResponseEntity<?> getProgramas(){
        List<Programas> programas = programasRepository.findAll();
        return  new ResponseEntity<>(programas, HttpStatus.OK);
    }

    @GetMapping(value = "getPrograma/{id}")
    public ResponseEntity<?> getPrograma(@PathVariable("id") String id){
        Programas programa = programasRepository.findById(Integer.valueOf(id)).get();
        return new ResponseEntity<>(programa, HttpStatus.OK);
    }

    @GetMapping("getProgramasPorFacultades/{codigoFacultad}")
    public ResponseEntity<?> getProgramasPorFacultades(@PathVariable("codigoFacultad") int codigoFacultad) {
        List<Areas> areas = areasRepository.findAreasByCodigoFacultad(codigoFacultad);
        List<Programas> programas = new ArrayList<>();
        for (Areas area : areas) {
            programas.add(programasRepository.findProgramasByCodigoArea(area.getCodigo()));
        }
        return ResponseEntity.ok(programas);
    }

}
