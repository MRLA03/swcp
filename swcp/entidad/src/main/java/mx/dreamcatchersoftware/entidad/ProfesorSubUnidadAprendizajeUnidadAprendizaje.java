/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.entidad;

import java.util.Collection;
/**
 *
 * @author acer
 */
public class ProfesorSubUnidadAprendizajeUnidadAprendizaje {
    private Profesor profesor;
    private SubUnidadAprendizaje subUnidadAprendizaje;
    private UnidadAprendizaje unidadAprendizaje;

    public ProfesorSubUnidadAprendizajeUnidadAprendizaje(Profesor profesor, SubUnidadAprendizaje subUnidadAprendizaje, UnidadAprendizaje unidadAprendizaje) {
        this.profesor = profesor;
        this.subUnidadAprendizaje = subUnidadAprendizaje;
        this.unidadAprendizaje = unidadAprendizaje;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public SubUnidadAprendizaje getSubUnidadAprendizaje() {
        return subUnidadAprendizaje;
    }

    public void setSubUnidadAprendizaje(SubUnidadAprendizaje subUnidadAprendizaje) {
        this.subUnidadAprendizaje = subUnidadAprendizaje;
    }

    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
    
    
}
