package org.datacoins.biblioteca.persistence.crud;

import org.datacoins.biblioteca.persistence.entity.Generos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroCrud extends JpaRepository<Generos, Integer> {
}
