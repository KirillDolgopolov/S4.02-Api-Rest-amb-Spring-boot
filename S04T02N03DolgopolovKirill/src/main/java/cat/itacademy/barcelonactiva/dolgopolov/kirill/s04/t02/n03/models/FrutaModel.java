package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n03.models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "fruta")

public class FrutaModel {

    @Id
    private ObjectId id;

    private String nombre;

    private int pesoKilos;
}
