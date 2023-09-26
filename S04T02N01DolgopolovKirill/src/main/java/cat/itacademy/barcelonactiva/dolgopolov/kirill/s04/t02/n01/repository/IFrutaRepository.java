package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.models.FrutaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaRepository extends JpaRepository<FrutaModel, Long> {
}
