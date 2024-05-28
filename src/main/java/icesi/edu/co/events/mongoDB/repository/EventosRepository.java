package icesi.edu.co.events.mongoDB.repository;

import icesi.edu.co.events.mongoDB.domain.Eventos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventosRepository extends MongoRepository<Eventos, Integer> {

    List<Eventos> findAll();

    List<Eventos> findByParticipantes_Id(String participanteId);
}
