package org.datacoins.biblioteca.dominio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.datacoins.biblioteca.persistence.crud.UbicacionCrud;
import org.datacoins.biblioteca.persistence.entity.Ubicacion;

@Service
public class UbicacionService implements IUbicacionService {

    // Inyección de dependencia del repositorio (UbicacionCrud)
    @Autowired
    private UbicacionCrud crud;

    @Override
    public List<Ubicacion> listarUbicaciones() {
        return crud.findAll();
    }

    @Override
    public Ubicacion buscarUbicacionPorId(Integer codigo) {
        return crud.findById(codigo).orElse(null);
    }

    @Override
    public void guardarUbicacion(Ubicacion ubicacion) {
        crud.save(ubicacion);
    }

    @Override
    public void eliminarUbicacion(Ubicacion ubicacion) {
        crud.delete(ubicacion);
    }
}
