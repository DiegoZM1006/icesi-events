package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.mongoDB.service.EventosService;
import icesi.edu.co.events.postgresDB.domain.Controller.FacultadesController;
import icesi.edu.co.events.postgresDB.domain.Empleados;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("eventos")
@RequiredArgsConstructor
public class EventosController {

    private final EventosRepository eventsRepository;
    private final EventosService eventService;
    private final EmpleadosRepository empleadosRepository;


    @PostMapping(value = "saveEvents")
    public ResponseEntity<?> saveEvent(@RequestBody Eventos events){
        Eventos saveEvents = new Eventos();
        saveEvents.setId(events.getId());
        saveEvents.setFecha(events.getFecha());
        saveEvents.setTitulo(events.getTitulo());
        saveEvents.setCategoria(events.getCategoria());
        saveEvents.setDescripcion(events.getDescripcion());
        saveEvents.setLugarDelEvento(events.getLugarDelEvento());
        saveEvents.setComentarios(events.getComentarios());
        saveEvents.setFacultades(events.getFacultades());
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

    @PostMapping(value = "getEvents/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") String id){
        List<Eventos> eventos = eventsRepository.findAll();
        List<Eventos> eventosFiltered = new ArrayList<>();

        for (Eventos evento : eventos) {
            for (Participantes idUser : evento.getParticipantes()) {
                if (idUser.getId() == id) {
                    eventosFiltered.add(evento);
                }
            }
        }

        return new ResponseEntity<>(eventosFiltered, HttpStatus.OK);
    }

    public List<Eventos> getEventById2(@PathVariable("id") String id){
        return eventsRepository.findAll().stream()
                .filter(evento -> evento.getParticipantes().stream().anyMatch(user -> user.getId() == id))
                .collect(Collectors.toList());
    }

    @PostMapping("getCategoriasEvents/{id}")
    public ResponseEntity<?> getCategorias(@PathVariable("id") String id){
        List<Eventos> eventos = eventsRepository.findAll();
        List<Eventos> eventosInscritos = getEventById2(id);

        Set<Eventos> eventosFiltered = eventos.stream()
                .filter(allEvents -> eventosInscritos.stream()
                        .anyMatch(suscribeEvents -> Arrays.stream(allEvents.getCategoria())
                                .anyMatch(categoriaAllEvents ->
                                        Arrays.stream(suscribeEvents.getCategoria())
                                                .anyMatch(categoriaSuscribeEvents ->
                                                        categoriaAllEvents.equals(categoriaSuscribeEvents)
                                                                && !Objects.equals(allEvents.getId(), suscribeEvents.getId())
                                                )
                                )
                        )
                ).collect(Collectors.toSet());

        return new ResponseEntity<>(eventosFiltered, HttpStatus.OK);
    }

    @PostMapping("saveEmpleado")
    public ResponseEntity<?> saveEmpleado(@RequestBody Empleados empleado){
        Participantes newParticipante = new Participantes();
        newParticipante.setId(empleado.getIdentificacion());
        newParticipante.setNombreCompleto(empleado.getNombres());
        newParticipante.setTipoRelacion(empleado.getTipoEmpleado().getNombre());
        newParticipante.setEmail(empleado.getEmail());

        return ResponseEntity.ok(newParticipante);
    }










}
