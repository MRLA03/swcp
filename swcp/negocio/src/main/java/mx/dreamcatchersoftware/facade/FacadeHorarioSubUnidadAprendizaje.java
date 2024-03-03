/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateHorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.HorarioSubUnidadAprendizaje;

/**
 *
 * @author acer
 */
public class FacadeHorarioSubUnidadAprendizaje {
    private final DelegateHorarioSubUnidadAprendizaje delegateHorarioSubUnidadAprendizaje;

    public FacadeHorarioSubUnidadAprendizaje() {
        this.delegateHorarioSubUnidadAprendizaje = new DelegateHorarioSubUnidadAprendizaje();
    }
    
    public void insertHorario(HorarioSubUnidadAprendizaje horario){
        delegateHorarioSubUnidadAprendizaje.insertHorario(horario);
    }
    
    public boolean insertHorarioSubUnidadAprendizaje(HorarioSubUnidadAprendizaje horario, String id_profesor){
        return delegateHorarioSubUnidadAprendizaje.insertHorarioSubUnidadAprendizaje(horario, id_profesor);
    }
    public List consultHorario(String id_profesor){
        return delegateHorarioSubUnidadAprendizaje.consultHorario(id_profesor);
    }
    
    public List consultHorarioIdProfesor(String id_profesor){
        return delegateHorarioSubUnidadAprendizaje.consultHorarioIdProfesor(id_profesor);
    }
    
    public List consultHorarioIdSubUnidadAprendizaje(String id_sub_unidad_aprendizaje){
        return delegateHorarioSubUnidadAprendizaje.consultHorarioIdSubUnidadAprendizaje(id_sub_unidad_aprendizaje);
    }
}
