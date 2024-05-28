package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.mongoDB.repository.ParticipantesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("participantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ParticipantesController {

    @Autowired
    ParticipantesRepository participantesRepository;
    @Autowired
    EventosRepository eventosRepository;

    @GetMapping("getParticipanteById/{id}")
    public ResponseEntity<?> getParticipanteById(@PathVariable("id") String id) {
        List<Eventos> eventosList = eventosRepository.findByParticipantes_Id(id);
        for (Eventos evento : eventosList) {
            List<Participantes> participantes = evento.getParticipantes();
            for (Participantes participante : participantes) {
                if (participante.getId().equals(id)) {
                    return ResponseEntity.ok(participante);
                }
            }
        }
        return null;
    }

}
