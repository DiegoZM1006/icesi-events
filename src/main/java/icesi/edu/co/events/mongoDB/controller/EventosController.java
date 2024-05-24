package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("eventos")
@RequiredArgsConstructor
public class EventosController {

    private final EventsRepository eventsRepository;

    @PostMapping(value = "saveEvents")
    public ResponseEntity<?> saveEvent(@RequestBody Eventos events){
        Eventos saveEvents = new Eventos();
        saveEvents.setId(events.getId());
        saveEvents.setFecha(events.getFecha());
        saveEvents.setTitulo(events.getTitulo());
        saveEvents.setDescripcion(events.getDescripcion());
        saveEvents.setAsistentes(events.getAsistentes());
        saveEvents.setLugarDelEvento(events.getLugarDelEvento());
        eventsRepository.save(saveEvents);
        return new ResponseEntity<>(saveEvents, HttpStatus.OK);
    }

}
