/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateProfesor {
    /**
     * Metodo de ejemplo para insertar Profesor
     * @param profesor de tipo usuario con id 0 para poder que se cree un id nuevo
     * @return 
     */
    public boolean insertProfesor(Profesor profesor){
        boolean bandera;
        try{
            ServiceLocator.getInstanceProfesorDAO().save(profesor);
            bandera=true;
        }catch(Exception e){
            System.out.println("Error al insertar profesor negocio-delegateProfesor 1");
            System.out.println("\n "+e);
            bandera=false;
        }
        return bandera;
    }

    //Consulta General de profesores
    public List consultProfesores(){
        List<Profesor> profesores = null;
        try{
            profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores negocio-delegateProfesor 2");
            System.out.println("\n "+e);            
        }
        return profesores;
    }
    
    // Consulta de usuarios por ID
    public Profesor consultProfesorID(int id_profesor){
        Profesor profesor = new Profesor();
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        try{                    
            for(Profesor pf:profesores){
                if(pf.getIdProfesor().toString().equalsIgnoreCase(String.valueOf(id_profesor))){
                    profesor = pf;
                }
            }           
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores por ID  por id negocio-delegateProfesor 3");
            System.out.println("\n "+e);            
        }
        return profesor;
    }
    // Consulta por Nombre y Apellido de Profesor
    public List consultProfesorNomApProfesor(String nombre_profesor, String apellidos_profesor){        
        List<Profesor> profesores = null;
        try{
            profesores =  ServiceLocator.getInstanceProfesorDAO().executeQuery("SELECT * FROM profesores WHERE nombre LIKE '%"+nombre_profesor+"%' AND apellido LIKE '%"+apellidos_profesor+"%';");
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores por Nombre y Apellido  por id negocio-delegateProfesor 4");
            System.out.println("\n "+e); 
        }
        
        return profesores;
    }
        
    
    // Eliminar profesores por id
    //PBI - PROF- UH4
  /*  public boolean deleteProfesor(int id_profesor){
        
    }
    */
    // Actualizar datos Profesor
    /*public void updateProfesor(int id_profesor){
        Profesor profesor = new Profesor();
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        for(Profesor pf:profesores){
            if(pf.getIdProfesor().equals(String.valueOf(id_profesor))){               
                profesor = pf;
            }
        }
        
        if(profesor == null || profesor.getIdProfesor() == 0) {
            throw new IllegalArgumentException("Error Actualizar Usuario Code: Negocio-delegateUsuario 2");
        }        
        ServiceLocator.getInstanceProfesorDAO().update(profesor);
    }*/
        
}
