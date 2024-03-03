/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateProfesor;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

public class FacadeProfesor {
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public boolean insertProfesor(Profesor profesor){
        return delegateProfesor.insertProfesor(profesor);
    }
    
    public List consultProfesores(){
        return delegateProfesor.consultProfesores();
    }
    
    public Profesor consultProfesorID(String id_profesor){
        return delegateProfesor.consultProfesorID(id_profesor);
    }
    public List consultProfesoresUnidadAprendizaje(){
        return delegateProfesor.consultProfesoresUnidadAprendizaje();
    }
    
    public List consultProfesoresxUnidadAprendizaje(String unidad_aprendizaje){
        return delegateProfesor.consultProfesoresxUnidadAprendizaje(unidad_aprendizaje);
    }
    
    public boolean deleteProfesorIdProfesor(String id_profesor){
        return delegateProfesor.deleteProfesorIdProfesor(id_profesor);
    }
}
