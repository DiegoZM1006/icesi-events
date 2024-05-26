package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.Participantes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistentesRepository extends MongoRepository<Participantes, Integer> {

}

