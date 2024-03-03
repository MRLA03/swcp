/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;

/**
 *
 * @author acer
 */
public class FacadeUnidadAprendizaje {
    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }
    
    public boolean insertUnidadAprendizaje(UnidadAprendizaje unidad){
        return delegateUnidadAprendizaje.insertUnidadAprendizaje(unidad);
    }
    
    public UnidadAprendizaje consultIdUnidadAprendizaje(String id_unidad_aprendizaje){
        return delegateUnidadAprendizaje.consultIdUnidadAprendizaje(id_unidad_aprendizaje);
    }
    
    public List consultNombreUnidadAprendizaje(String nombre){
        return delegateUnidadAprendizaje.consultNombreUnidadAprendizaje(nombre);
    }
}
