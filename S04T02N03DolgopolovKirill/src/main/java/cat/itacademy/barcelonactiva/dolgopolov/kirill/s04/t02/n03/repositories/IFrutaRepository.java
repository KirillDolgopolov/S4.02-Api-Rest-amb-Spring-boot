package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.repositories;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.models.FrutaModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IFrutaRepository extends MongoRepository<FrutaModel, ObjectId> {
}
