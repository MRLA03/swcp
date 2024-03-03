/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

//import mx.dreamcatchersoftware.facade.FacadeHorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.facade.FacadeHorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.facade.FacadeProfesor;
import mx.dreamcatchersoftware.facade.FacadeSubUnidadAprendizaje;
import mx.dreamcatchersoftware.facade.FacadeSubUnidadAprendizaje;
import mx.dreamcatchersoftware.facade.FacadeUnidadAprendizaje;
import mx.dreamcatchersoftware.facade.FacadeUsuario;
/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeHorarioSubUnidadAprendizaje facadeHorarioSubUnidadAprendizaje;
    private static FacadeProfesor facadeProfesor;
    private static FacadeSubUnidadAprendizaje facadeSubUnidadAprendizaje;
    private static FacadeUnidadAprendizaje facadeUnidadAprendizaje;
    private static FacadeUsuario facadeUsuario;    
    
    public static FacadeHorarioSubUnidadAprendizaje getInstanceFacadeHorarioSubUnidadAprendizaje() {
        if (facadeHorarioSubUnidadAprendizaje == null) {
            facadeHorarioSubUnidadAprendizaje = new FacadeHorarioSubUnidadAprendizaje();
            return facadeHorarioSubUnidadAprendizaje;
        } else {
            return facadeHorarioSubUnidadAprendizaje;
        }
    }
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
    
    public static FacadeSubUnidadAprendizaje getInstanceFacadeSubUnidadAprendizaje() {
        if (facadeSubUnidadAprendizaje == null) {
            facadeSubUnidadAprendizaje = new FacadeSubUnidadAprendizaje();
            return facadeSubUnidadAprendizaje;
        } else {
            return facadeSubUnidadAprendizaje;
        }
    }
    
    public static FacadeUnidadAprendizaje getInstanceFacadeUnidadAprendizaje() {
        if (facadeUnidadAprendizaje == null) {
            facadeUnidadAprendizaje = new FacadeUnidadAprendizaje();
            return facadeUnidadAprendizaje;
        } else {
            return facadeUnidadAprendizaje;
        }
    }
    
    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }    
}
