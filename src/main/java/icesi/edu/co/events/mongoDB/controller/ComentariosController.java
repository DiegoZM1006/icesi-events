package icesi.edu.co.events.mongoDB.controller;

import icesi.edu.co.events.mongoDB.domain.Comentarios;
import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.ComentariosRepository;
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
@RequestMapping("comentarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class ComentariosController {

    private final ComentariosRepository comentariosRepository;

    @GetMapping("getAllComentarios")
    public ResponseEntity<?> getAllComentarios(){
        List<Comentarios> comentarios = comentariosRepository.findAll();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }



}
