package ar.com.ada.api.xmen.repositories;

import ar.com.ada.api.xmen.entities.Mutant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends MongoRepository<Mutant, ObjectId> {

}
