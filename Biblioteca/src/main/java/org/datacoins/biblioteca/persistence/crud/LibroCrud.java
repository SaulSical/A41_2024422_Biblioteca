package org.datacoins.biblioteca.persistence.crud;

import org.datacoins.biblioteca.persistence.entity.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroCrud extends JpaRepository <Libros ,Integer>{
}
