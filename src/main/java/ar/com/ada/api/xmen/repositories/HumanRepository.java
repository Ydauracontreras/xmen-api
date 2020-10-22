package ar.com.ada.api.xmen.repositories;

import ar.com.ada.api.xmen.entities.Human;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends MongoRepository<Human, ObjectId> {

    Human findBy_id(ObjectId _id);

    Human findByUniqueHash(String hash);

}
