package org.datacoins.biblioteca.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.datacoins.biblioteca.dominio.service.IUbicacionService;
import org.datacoins.biblioteca.persistence.entity.Ubicacion;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class UbicacionController {

    @Autowired
    private IUbicacionService ubicacionService;

    private List<Ubicacion> ubicaciones;
    private Ubicacion ubicacionSeleccionada;

    private static final Logger logger = LoggerFactory.getLogger(UbicacionController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.ubicaciones = this.ubicacionService.listarUbicaciones();
        this.ubicaciones.forEach(ubicacion -> logger.info(ubicacion.toString()));
    }

    public void agregarUbicacion() {
        this.ubicacionSeleccionada = new Ubicacion();
    }

    public void guardarUbicacion() {
        logger.info("Ubicación a guardar: " + this.ubicacionSeleccionada);

        this.ubicacionService.guardarUbicacion(this.ubicacionSeleccionada);

        cargarDatos();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(this.ubicacionSeleccionada.getCodigoUbicacion() == null ?
                        "Ubicación agregada" : "Ubicación actualizada"));

        PrimeFaces.current().executeScript("PF('VentanaModalUbicacion').hide()");
        PrimeFaces.current().ajax().update("formulario-ubicaciones:mensaje_emergente",
                "formulario-ubicaciones:tabla-ubicaciones");

        this.ubicacionSeleccionada = null;
    }

    public void eliminarUbicacion() {
        logger.info("Ubicación a eliminar: " + this.ubicacionSeleccionada);
        this.ubicacionService.eliminarUbicacion(ubicacionSeleccionada);
        this.ubicaciones.remove(ubicacionSeleccionada);
        this.ubicacionSeleccionada = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ubicación eliminada"));
        PrimeFaces.current().ajax().update("formulario-ubicaciones:mensaje_emergente",
                "formulario-ubicaciones:tabla-ubicaciones");
    }
}
