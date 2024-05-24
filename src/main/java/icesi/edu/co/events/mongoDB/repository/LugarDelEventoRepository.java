package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.LugarDelEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarDelEventoRepository extends MongoRepository<LugarDelEvento, Integer> {

}
