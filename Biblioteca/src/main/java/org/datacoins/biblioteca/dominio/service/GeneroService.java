package org.datacoins.biblioteca.dominio.service;

import org.datacoins.biblioteca.persistence.crud.GeneroCrud;
import org.datacoins.biblioteca.persistence.crud.LibroCrud;
import org.datacoins.biblioteca.persistence.entity.Generos;
import org.datacoins.biblioteca.persistence.entity.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    @Autowired
    private GeneroCrud crud;

    @Override
    public List<Generos> listarGeneros() {
        List<Generos> generos = crud.findAll();
        return generos;
    }

}
