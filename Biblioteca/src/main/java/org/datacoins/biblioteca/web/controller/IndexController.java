package org.datacoins.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.datacoins.biblioteca.dominio.service.ILibroService;
import org.datacoins.biblioteca.persistence.entity.Libros;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    private ILibroService libroService;

    private List<Libros> libros;
    private Libros libroSeleccionado;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.libros = libroService.listarLibros();
        this.libros.forEach(libro -> logger.info(libro.toString()));
    }

    public void agregarLibro() {
        this.libroSeleccionado = new Libros();
    }

    public void guardarLibro() {
        logger.info("Libro a guardar: " + this.libroSeleccionado);

        if (this.libroSeleccionado.getCodigoLibro() == null) {
            libroService.guardarLibro(this.libroSeleccionado);
            this.libros.add(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Libro agregado"));
        } else {
            libroService.guardarLibro(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Libro actualizado"));
        }

        PrimeFaces.current().executeScript("PF('VentanaModalLibro').hide()");
        PrimeFaces.current().ajax().update("formulario-libros:mensaje_emergente", "formulario-libros:tabla-libros");

        this.libroSeleccionado = null;
    }

    public void eliminarLibro() {
        logger.info("Libro a eliminar: " + this.libroSeleccionado);

        libroService.eliminarLibro(libroSeleccionado);
        this.libros.remove(libroSeleccionado);
        this.libroSeleccionado = null;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Libro eliminado"));
        PrimeFaces.current().ajax().update("formulario-libros:mensaje_emergente", "formulario-libros:tabla-libros");
    }
}
