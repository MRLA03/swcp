/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.integracion;

import mx.dreamcatchersoftware.DAO.HorarioSubUnidadAprendizajeDAO;
import mx.dreamcatchersoftware.DAO.ProfesorDAO;
import mx.dreamcatchersoftware.DAO.SubUnidadAprendizajeDAO;
import mx.dreamcatchersoftware.DAO.UnidadAprendizajeDAO;
import mx.dreamcatchersoftware.DAO.UsuarioDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static HorarioSubUnidadAprendizajeDAO horarioSubUnidadAprendizajeDAO;
    private static ProfesorDAO profesorDAO;
    private static SubUnidadAprendizajeDAO subUnidadAprendizajeDAO;
    private static UnidadAprendizajeDAO unidadAprendizajeDAO;
    private static UsuarioDAO usuarioDAO;    
    /**
     * se crea la instancia para horarioSubUnidadAprendizaje DAO si esta no existe
     */
    public static HorarioSubUnidadAprendizajeDAO getInstanceHorarioSubUnidadAprendizajeDAO(){
        if(horarioSubUnidadAprendizajeDAO == null){
            horarioSubUnidadAprendizajeDAO = new HorarioSubUnidadAprendizajeDAO();
            return horarioSubUnidadAprendizajeDAO;
        } else{
            return horarioSubUnidadAprendizajeDAO;
        }
    }
    /**
     * se crea la instancia para profesor DAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia para subUnidadAprendizaje DAO si esta no existe
     */
    public static SubUnidadAprendizajeDAO getInstanceSubUnidadAprendizajeDAO(){
        if(subUnidadAprendizajeDAO == null){
            subUnidadAprendizajeDAO = new SubUnidadAprendizajeDAO();
            return subUnidadAprendizajeDAO;
        } else{
            return subUnidadAprendizajeDAO;
        }
    }
    /**
     * se crea la instancia para unidadAprendizaje DAO si esta no existe
     */
    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadAprendizajeDAO();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
}
