package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.Eventos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends MongoRepository<Eventos, Integer> {

}
