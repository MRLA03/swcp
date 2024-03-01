/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateSubUnidadAprendizaje;

/**
 *
 * @author acer
 */
public class FacadeSubUnidadAprendizaje {
    private final DelegateSubUnidadAprendizaje delegateSubUnidadAprendizaje;

    public FacadeSubUnidadAprendizaje() {
        this.delegateSubUnidadAprendizaje = new DelegateSubUnidadAprendizaje();
    }
    
    public List consultProfesorUnidadAprendizaje(String nombre_unidad_aprendizaje){
        return delegateSubUnidadAprendizaje.consultProfesorUnidadAprendizaje(nombre_unidad_aprendizaje);
    }
}
