package cat.itacademy.barcelonactiva.dolgopolov.kirill.s04.t02.n02.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fruta")
@Setter
@Getter


public class FrutaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private int pesoKilos;

}
