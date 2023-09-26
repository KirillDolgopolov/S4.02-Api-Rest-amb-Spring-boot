package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n01.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "fruta")
public class FrutaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column
    private String nombre;
    @Column
    private int pesoKilos;
}
