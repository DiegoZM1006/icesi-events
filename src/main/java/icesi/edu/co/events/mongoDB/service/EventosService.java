package icesi.edu.co.events.mongoDB.service;

import icesi.edu.co.events.mongoDB.domain.Asistentes;
import icesi.edu.co.events.mongoDB.domain.Ciudades;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.mongoDB.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventosService {

    @Autowired
    EventosRepository eventosRepository;

    public List<Eventos> findAll(){
        return eventosRepository.findAll();
    }

    public Eventos update(int id, Eventos events){
        Eventos eventToUpdate = eventosRepository.findById(id).get();
        eventToUpdate.setId(events.getId());
        eventToUpdate.setFecha(events.getFecha());
        eventToUpdate.setTitulo(events.getTitulo());
        eventToUpdate.setCategoria(events.getCategoria());
        eventToUpdate.setDescripcion(events.getDescripcion());
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
        eventToUpdate.setAsistentes(asistentesList);
        eventToUpdate.setLugarDelEvento(events.getLugarDelEvento());
        eventToUpdate.setComentarios(events.getComentarios());
        return eventosRepository.save(events);
    }
}
