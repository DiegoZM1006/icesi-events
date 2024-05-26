package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.mongoDB.service.EventosService;
import icesi.edu.co.events.postgresDB.domain.Ciudades;
import icesi.edu.co.events.postgresDB.domain.Controller.FacultadesController;
import icesi.edu.co.events.postgresDB.domain.Empleados;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.EmpleadosRepository;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
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
@CrossOrigin(origins = "http://localhost:5173/")
public class EventosController {

    private final EventosRepository eventsRepository;
    private final EventosService eventService;
    private final EmpleadosRepository empleadosRepository;
    private final UsuariosRepository usuariosRepository;


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
        List<Participantes> participantes = new ArrayList<>();
        if (events.getParticipantes() != null) {
            for (Participantes participante : events.getParticipantes()) {
                Optional<Usuarios> searchUser = usuariosRepository.findById(participante.getId());
                if (searchUser.isPresent()) {
                    Participantes participanteSave = new Participantes();
                    participanteSave.setId(String.valueOf(searchUser.get().getId()));
                    participanteSave.setRole(participante.getRole());
                    participanteSave.setUsuario(searchUser.get());
                    participantes.add(participanteSave);
                }
            }
            saveEvents.setParticipantes(participantes);
        }
        saveEvents.setProgramas(events.getProgramas());
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

    @GetMapping(value = "getEventsById/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") int id){
        return new ResponseEntity<>(eventsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "getEvents/{id}")
    public ResponseEntity<?> getEventByIdEvent(@PathVariable("id") String id){
        List<Eventos> eventos = eventsRepository.findAll();
        List<Eventos> eventosFiltered = new ArrayList<>();

        for (Eventos evento : eventos) {
            if(evento.getParticipantes() != null){
                for (Participantes idUser : evento.getParticipantes()) {
                    if (idUser.getUsuario().getId().equals(id)) {
                        eventosFiltered.add(evento);
                    }
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

    @PostMapping("saveEmpleado/{nombreusuario}/{password}")
   public ResponseEntity<?> saveEmpleado(@PathVariable("nombreusuario") String nombreusuario, @RequestBody Empleados empleado, @PathVariable("password") String password){
        Usuarios newUsuario= new Usuarios();
        newUsuario.setId(empleado.getIdentificacion());
        newUsuario.setNombre(nombreusuario);
       newUsuario.setPassword(password);
        newUsuario.setRol("asistente");
        newUsuario.setNombre(empleado.getNombres());
        newUsuario.setTipoRelacion(empleado.getTipoEmpleado().getNombre());
        newUsuario.setEmail(empleado.getEmail());
        Ciudades ciudad = new Ciudades();
        ciudad.setNombre(empleado.getLugarNacimiento().getNombre());
       ciudad.setDepartamento(empleado.getLugarNacimiento().getDepartamento());
       ciudad.getDepartamento().setPais(empleado.getLugarNacimiento().getDepartamento().getPais());
       newUsuario.setCiudad(ciudad);

       return ResponseEntity.ok(newUsuario);
    }






}
