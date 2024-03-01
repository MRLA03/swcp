/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateProfesorSubUnidadAprendizajeUnidadAprendizaje;

/**
 *
 * @author acer
 */
public class FacadeProfesorSubUnidadAprendizajeUnidadAprendizaje {
    private final DelegateProfesorSubUnidadAprendizajeUnidadAprendizaje delegateProfesorSubUnidadAprendizajeUnidadAprendizaje;

    public FacadeProfesorSubUnidadAprendizajeUnidadAprendizaje() {
        this.delegateProfesorSubUnidadAprendizajeUnidadAprendizaje = new DelegateProfesorSubUnidadAprendizajeUnidadAprendizaje();
    }
    
    public List consultProfesorUnidadAprendizaje(String nombre_unidad_aprendizaje){
        return delegateProfesorSubUnidadAprendizajeUnidadAprendizaje.consultProfesorUnidadAprendizaje(nombre_unidad_aprendizaje);
    }
}
