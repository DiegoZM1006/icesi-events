package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Comentarios;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.repository.ComentariosRepository;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.mongoDB.service.EventosService;
import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("comentarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ComentariosController {

    @Autowired
    private final ComentariosRepository comentariosRepository;
    @Autowired
    private final EventosService eventosService;
    @Autowired
    private final EventosRepository eventosRepository;
    @Autowired
    private final UsuariosRepository usuariosRepository;

    @GetMapping("getAllComentarios")
    public ResponseEntity<?> getAllComentarios(){
        List<Comentarios> comentarios = comentariosRepository.findAll();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @PostMapping("saveComentariosById/{id}")
    public Eventos saveComentariosById(@PathVariable("id") int id, @RequestBody Comentarios comentarioPagina){

        List<Comentarios> comentarios = new ArrayList<>();
        Optional<Eventos> events = eventosRepository.findById(id);
        Comentarios newComentarios = new Comentarios();
        if(events.isPresent()){
            Eventos newEvent = events.get();
            newComentarios.setContenido(comentarioPagina.getContenido());
            newComentarios.setUsername(comentarioPagina.getUsername());
            newComentarios.setFecha(comentarioPagina.getFecha());
            newComentarios.setId(comentarioPagina.getId());

            if(newEvent.getComentarios() == null){
                comentarios.add(newComentarios);
            }else{
                comentarios = newEvent.getComentarios();
                comentarios.add(newComentarios);
            }
            newEvent.setComentarios(comentarios);
            return eventosRepository.save(newEvent);
        }

       return null;
    }

}
