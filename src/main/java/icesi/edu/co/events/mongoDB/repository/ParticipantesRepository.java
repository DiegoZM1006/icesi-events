package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParticipantesRepository extends MongoRepository<Participantes, String> {
    List<Participantes> findAll();

    //Optional<Participantes> findById(String id);
}
