package org.datacoins.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Generos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoGenero")
    private Integer codigoGenero;

    @Column(name = "tipoGenero")
    private String tipoGenero;

}
