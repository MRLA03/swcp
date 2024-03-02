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
 * @author Usuario
 */
public class FacadeUnidadAprendizaje {
    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;
    
    public FacadeUnidadAprendizaje(){
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }
    
    public void insertUnidadAprendizaje(UnidadAprendizaje unidadaprendizaje){
        delegateUnidadAprendizaje.insertUnidadAprendizaje(unidadaprendizaje);
    }
    
    public List consultUnidadAprendizaje(){
        return delegateUnidadAprendizaje.consultUnidadAprendizaje();
    }
    
    public UnidadAprendizaje consultUnidadAprendizajeID(int id_unidadaprendizaje){
        return delegateUnidadAprendizaje.consultUnidadAprendizajeID(id_unidadaprendizaje);
    }
}
