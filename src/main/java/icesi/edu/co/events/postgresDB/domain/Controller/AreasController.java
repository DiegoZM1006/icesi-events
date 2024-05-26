package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Areas;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.repository.AreasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("areas")
@RequiredArgsConstructor
public class AreasController {

    private final AreasRepository areasRepository;

    @GetMapping(value = "getAreas")
    public ResponseEntity<?> getAreas(){
        List<Areas> areas = areasRepository.findAll();
        return  new ResponseEntity<>(areas, HttpStatus.OK);
    }

}
