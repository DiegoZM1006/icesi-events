package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.Comentarios;
import icesi.edu.co.events.mongoDB.domain.Eventos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComentariosRepository extends MongoRepository<Comentarios, Integer> {
    List<Comentarios> findAll();

}
