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
    private Integer codigoLibro;

    @Column
    private String titulo;
    private Integer cantidad;
    private String autor;
    private Integer codigoGenero;
    private Integer codigoUbicacion;

}





