package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.repositories;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.models.FrutaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFrutaRepository extends JpaRepository<FrutaModel, Long> {
}
