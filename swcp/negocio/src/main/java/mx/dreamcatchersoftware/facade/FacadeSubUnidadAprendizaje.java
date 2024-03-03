/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateSubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;

/**
 *
 * @author acer
 */
public class FacadeSubUnidadAprendizaje {
    private final DelegateSubUnidadAprendizaje delegateSubUnidadAprendizaje;

    public FacadeSubUnidadAprendizaje() {
        this.delegateSubUnidadAprendizaje = new DelegateSubUnidadAprendizaje();
    }
   
    
    public List consultSubUnidadAprendizaje(){
       return delegateSubUnidadAprendizaje.consultSubUnidadAprendizaje();
    }
    
    public SubUnidadAprendizaje consultSubUnidadAprendizajeIdUnidadAprendizaje(String id_unidad){
        return delegateSubUnidadAprendizaje.consultSubUnidadAprendizajeIdUnidadAprendizaje(id_unidad);
    }
    public List consultSubUnidadAprendizajeIdProfesor(String id_profesor){
       return delegateSubUnidadAprendizaje.consultSubUnidadAprendizajeIdProfesor(id_profesor);
    }        
    
    public boolean updateSubUnidadAprendizajeId_SubUnidadAprendizaje(SubUnidadAprendizaje sub_unidad){
        return delegateSubUnidadAprendizaje.updateSubUnidadAprendizajeId_SubUnidadAprendizaje(sub_unidad);
    }
}
