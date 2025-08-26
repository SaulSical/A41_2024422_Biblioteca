package org.datacoins.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoLibro")
    private Integer codigoLibro;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "autor")
    private String autor;
    @Column(name = "codigoGenero")
    private Integer codigoGenero;
    @Column(name = "codigoUbicacion")
    private Integer codigoUbicacion;

}





