/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateUnidadAprendizaje {
    
    public UnidadAprendizaje consultIdUnidadAprendizaje(String id_unidad_aprendizaje){
        UnidadAprendizaje unidad = new UnidadAprendizaje();
        try{
            List<UnidadAprendizaje> unidadesAprendizaje=  ServiceLocator.getInstanceUnidadAprendizajeDAO().executeQuery("SELECT * FROM unidad_aprendizaje WHERE id_unidad_aprendizaje = "+id_unidad_aprendizaje+";");
            for(UnidadAprendizaje u: unidadesAprendizaje){
                unidad = u;
            }
        }catch(Exception e){
            System.out.println("Error en busqueda por id_unidad aprendizaje consultIdUnidadAprendizaje\n"+e);
        }
        return unidad;
    }
    
    public List consultNombreUnidadAprendizaje(String nombre){
        List<UnidadAprendizaje> unidadesAprendizaje =  new ArrayList<>();
        UnidadAprendizaje unidad = new UnidadAprendizaje();
        try{
            unidadesAprendizaje =  ServiceLocator.getInstanceUnidadAprendizajeDAO().executeQuery("SELECT * FROM unidad_aprendizaje WHERE nombre LIKE '%"+nombre+"%';");
        }catch(Exception e){
            System.out.println("Error en busqueda por id_unidad aprendizaje consultIdUnidadAprendizaje\n"+e);
        }
        return unidadesAprendizaje;
    }
    // Consulta general
    public List consultUnidadAprendizaje(){
        List<UnidadAprendizaje> unidades = new ArrayList<>();
        List<String[]> cadenas = new ArrayList<>();
        try{
            unidades = ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
            for(UnidadAprendizaje u: unidades){
                
            }
        }catch(Exception e){
            System.out.println("Error al hacer la consulta en UnidadAprendizaje\n"+e);
        }
        // NO ESTA TERMINADO
        return unidades;
    }
    
    //CREAR INSERT
    public boolean insertUnidadAprendizaje(UnidadAprendizaje unidad){
        boolean bandera= true;
        UnidadAprendizaje u = new UnidadAprendizaje();
        try{
            u = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultIdUnidadAprendizaje(unidad.getIdUnidadAprendizaje().toString());
            if(u.getNombre() !=""){
                ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidad);
            }else{
                bandera = false;
            }
        }catch(Exception e){
            System.out.println("Error al insertar unidad_aprendizaje\n"+e);
        }
        return bandera;
    }
    //CREAR UPDATE
}
