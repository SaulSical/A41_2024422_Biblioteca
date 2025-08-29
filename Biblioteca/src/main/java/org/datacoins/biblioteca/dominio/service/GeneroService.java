package org.datacoins.biblioteca.dominio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.datacoins.biblioteca.persistence.crud.GeneroCrud;
import org.datacoins.biblioteca.persistence.entity.Generos;

@Service
public class GeneroService implements IGeneroService {

    // Inyección de dependencia del repositorio (GeneroCrud)
    @Autowired
    private GeneroCrud crud;

    @Override
    public List<Generos> listarGeneros() {
        return crud.findAll();
    }

    @Override
    public Generos buscarGeneroPorId(Integer codigo) {
        return crud.findById(codigo).orElse(null);
    }

    @Override
    public void guardarGenero(Generos genero) {
        crud.save(genero);
    }

    @Override
    public void eliminarGenero(Generos genero) {
        crud.delete(genero);
    }
}
