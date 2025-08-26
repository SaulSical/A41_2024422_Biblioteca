package org.datacoins.biblioteca.dominio.service;
import org.datacoins.biblioteca.persistence.entity.Libros;
import java.util.List;

public interface ILibroService {
    List<Libros> listarLibros();
    Libros buscarLibroProId(Integer codigo);
    void guardarLibro(Libros libros);
    void eliminarLibro(Libros libros);
}


