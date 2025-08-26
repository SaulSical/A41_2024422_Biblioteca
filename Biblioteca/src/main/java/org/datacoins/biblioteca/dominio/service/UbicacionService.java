package org.datacoins.biblioteca.dominio.service;

import org.datacoins.biblioteca.persistence.crud.GeneroCrud;
import org.datacoins.biblioteca.persistence.crud.LibroCrud;
import org.datacoins.biblioteca.persistence.crud.UbicacionCrud;
import org.datacoins.biblioteca.persistence.entity.Generos;
import org.datacoins.biblioteca.persistence.entity.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService implements IUbicacionService {

    @Autowired
    private UbicacionCrud crud;

    @Override
    public List<Ubicacion> listarUbicacion() {
        List<Ubicacion> ubicacion = crud.findAll();
        return ubicacion;
    }
}
