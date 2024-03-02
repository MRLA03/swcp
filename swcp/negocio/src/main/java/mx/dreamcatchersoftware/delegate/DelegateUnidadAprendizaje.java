/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.List;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateUnidadAprendizaje {
    public void insertUnidadAprendizaje(UnidadAprendizaje unidadaprendizaje){
        try{
            ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadaprendizaje);            
        }catch(Exception e){
            System.out.println("Error al insertar usuario negocio-delegateUsuario 1");
            System.out.println("\n "+e);            
        }
    }
    public UnidadAprendizaje consultUnidadAprendizajeID(int id_unidadaprendizaje){
        UnidadAprendizaje unidadaprendizaje = new UnidadAprendizaje();
        List<UnidadAprendizaje> unidadesaprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
        try{
            for(UnidadAprendizaje ua:unidadesaprendizaje){
                if(ua.getIdUnidadAprendizaje().toString().equalsIgnoreCase(String.valueOf(id_unidadaprendizaje))){
                    unidadaprendizaje = ua;
                }
            }
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario  por id negocio-delegateUsuario 4");
            System.out.println("\n "+e);               
        }
        return unidadaprendizaje;
    }

    public List consultUnidadAprendizaje(){
        List<UnidadAprendizaje> unidadesaprendizaje = null;
        try{
            unidadesaprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario negocio-delegateUsuario 3");
            System.out.println("\n "+e);            
        }
        return unidadesaprendizaje;
    }    
}
