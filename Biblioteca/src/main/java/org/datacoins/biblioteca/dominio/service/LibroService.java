package org.datacoins.biblioteca.dominio.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.datacoins.biblioteca.persistence.crud.LibroCrud;
import org.datacoins.biblioteca.persistence.entity.Libros;

@Service
public class LibroService implements ILibroService {

    //Ingeyeccion de dependencia de mi repositorio (ClienteCrud) (ClienteRepositori)
    @Autowired
    private LibroCrud crud;

    @Override
    public List<Libros> listarLibros() {
        List<Libros> libros = crud.findAll();
        return libros;
    }

    @Override
    public Libros buscarLibroProId(Integer codigo) {
        Libros libros = crud.findById(codigo).orElse(null );
        return libros;
    }

    @Override
    public void guardarLibro(Libros libros) {
        crud.save(libros);
    }

    @Override
    public void eliminarLibro(Libros libros) {
        crud.delete(libros);
    }
}



