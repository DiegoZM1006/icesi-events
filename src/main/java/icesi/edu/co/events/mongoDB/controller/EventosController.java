package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Asistentes;
import icesi.edu.co.events.mongoDB.domain.Ciudades;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.mongoDB.service.EventosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("eventos")
@RequiredArgsConstructor
public class EventosController {

    private final EventosRepository eventsRepository;
    private final EventosService eventService;

    @PostMapping(value = "saveEvents")
    public ResponseEntity<?> saveEvent(@RequestBody Eventos events){
        Eventos saveEvents = new Eventos();
        saveEvents.setId(events.getId());
        saveEvents.setFecha(events.getFecha());
        saveEvents.setTitulo(events.getTitulo());
        saveEvents.setCategoria(events.getCategoria());
        saveEvents.setDescripcion(events.getDescripcion());
        List<Asistentes> asistentesList = new ArrayList<>();
        for (Asistentes asistente : events.getAsistentes()) {
            Asistentes saveAsistente = new Asistentes();
            Ciudades saveCiudad = new Ciudades();
            saveAsistente.setId(asistente.getId());
            saveAsistente.setIdentificador(asistente.getIdentificador());
            saveAsistente.setNombreUsuario(asistente.getNombreUsuario());
            saveAsistente.setNombreCompleto(asistente.getNombreCompleto());
            saveAsistente.setTipoRelacion(asistente.getTipoRelacion());
            saveAsistente.setEmail(asistente.getEmail());
            saveCiudad.setNombre(asistente.getCiudad().getNombre());
            saveCiudad.setPais(asistente.getCiudad().getPais());
            saveCiudad.setDepartamento(asistente.getCiudad().getDepartamento());
            saveAsistente.setCiudad(saveCiudad);
            asistentesList.add(saveAsistente);

        }
        saveEvents.setAsistentes(asistentesList);
        saveEvents.setLugarDelEvento(events.getLugarDelEvento());
        saveEvents.setComentarios(events.getComentarios());
        eventsRepository.save(saveEvents);
        return new ResponseEntity<>(saveEvents, HttpStatus.OK);
    }

    @PutMapping(value = "updateEvents/{id}")
    public ResponseEntity<Eventos> updateEvent(@PathVariable("id") int id,  @RequestBody Eventos eventos){
        return ResponseEntity.ok(eventService.update(id, eventos));
    }

    @GetMapping(value = "getEvents")
    public ResponseEntity<?> getEvent(){
        List<Eventos> eventos = eventsRepository.findAll();
        return  new ResponseEntity<>(eventos, HttpStatus.OK);
    }

}
