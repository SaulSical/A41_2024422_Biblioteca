package org.datacoins.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoUbicacion")
    private Integer codigoUbicacion;

    @Column(name = "edificio")
    private String edificio;

    @Column(name = "sala")
    private String sala;

    @Column(name = "estante")
    private String estante;

    @Column(name = "fila")
    private String fila;

    @Column(name = "columna")
    private String columna;

}
