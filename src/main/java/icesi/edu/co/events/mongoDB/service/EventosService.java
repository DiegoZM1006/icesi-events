package icesi.edu.co.events.mongoDB.service;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import icesi.edu.co.events.mongoDB.domain.Ciudades;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventosService {

    @Autowired
    EventosRepository eventosRepository;

    @Autowired
    UsuariosRepository usuariosRepository;

    public List<Eventos> findAll(){
        return eventosRepository.findAll();
    }

    public Eventos update(int id, Eventos events){
        Eventos eventToUpdate = eventosRepository.findById(id).get();
        eventToUpdate.setFecha(events.getFecha());
        eventToUpdate.setTitulo(events.getTitulo());
        eventToUpdate.setCategoria(events.getCategoria());
        eventToUpdate.setDescripcion(events.getDescripcion());
        eventToUpdate.setFacultades(events.getFacultades());
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
            eventToUpdate.setParticipantes(participantes);
        }
        eventToUpdate.setParticipantes(participantes);
        eventToUpdate.setProgramas(events.getProgramas());
        eventToUpdate.setLugarDelEvento(events.getLugarDelEvento());
        eventToUpdate.setComentarios(events.getComentarios());
        return eventosRepository.save(eventToUpdate);
    }
}
