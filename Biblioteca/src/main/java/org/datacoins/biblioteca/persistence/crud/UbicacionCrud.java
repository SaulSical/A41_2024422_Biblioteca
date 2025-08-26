package org.datacoins.biblioteca.persistence.crud;

import org.datacoins.biblioteca.persistence.entity.Generos;
import org.datacoins.biblioteca.persistence.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionCrud extends JpaRepository<Ubicacion, Integer> {
}
