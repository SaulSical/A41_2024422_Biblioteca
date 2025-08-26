package org.datacoins.biblioteca.dominio.service;

import org.datacoins.biblioteca.persistence.entity.Generos;

import java.util.List;

public interface IGeneroService {
    List<Generos> listarGeneros();
}
