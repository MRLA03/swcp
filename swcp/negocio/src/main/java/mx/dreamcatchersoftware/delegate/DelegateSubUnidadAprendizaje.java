/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

public class DelegateSubUnidadAprendizaje {
    
    public List consultSubUnidadAprendizaje(){
        List<SubUnidadAprendizaje> subunidad = new ArrayList<>();
        try{
            subunidad = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().findAll();
        }catch(Exception e){
            System.out.println("DelegtSubUnidad Aprendizaje\n"+e);
        }
        return subunidad;
    }
    
    public SubUnidadAprendizaje consultSubUnidadAprendizajeIdUnidadAprendizaje(String id_unidad){
        SubUnidadAprendizaje sub = new SubUnidadAprendizaje();
        try{
           List<SubUnidadAprendizaje> subunidad = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeQuery("SELECT * FROM sub_unidad_aprendizaje WHERE id_unidad_aprendizaje = "+id_unidad+";");            
           for(SubUnidadAprendizaje s: subunidad){
               sub = s;
           } 
        }catch(Exception e){
            System.out.println("DelegtSubUnidad Aprendizaje\n"+e);
        }
        return sub;
    }
       
    public List consultSubUnidadAprendizajeIdProfesor(String id_profesor){        
        List<SubUnidadAprendizaje> subunidad = new ArrayList<>();
        List<String[]> completo = new ArrayList<>();        
        try{            
        /*Profesor prof = new Profesor();
        prof = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(id_profesor);*/
            subunidad = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeQuery("SELECT * FROM sub_unidad_aprendizaje WHERE id_profesor = "+id_profesor+";");            
            for(SubUnidadAprendizaje sub: subunidad){
                String[] cadena = new String[4];
                cadena[0] = ""+sub.getIdSubUnidadAprendizaje();
                cadena[1] = ""+sub.getIdUnidadAprendizaje().getIdUnidadAprendizaje();
                cadena[2] = ""+sub.getIdUnidadAprendizaje().getNombre();
                cadena[3] = ""+sub.getTipo();
                completo.add(cadena);
            }
        }catch(Exception e){
            System.out.println("DelegtSubUnidad Aprendizaje\n"+e);
        }
        return completo;
    }
    
    public boolean updateSubUnidadAprendizajeId_SubUnidadAprendizaje(SubUnidadAprendizaje sub_unidad){
        boolean correcto = true;
        SubUnidadAprendizaje sub = new SubUnidadAprendizaje();
        System.out.println("UUUUUUUUUUUUUU:: "+sub_unidad.getIdSubUnidadAprendizaje().toString());
        try{
            sub = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizajeIdUnidadAprendizaje(sub_unidad.getIdSubUnidadAprendizaje().toString());
            if(sub.getTipo() !=""){
                ServiceLocator.getInstanceSubUnidadAprendizajeDAO().update(sub_unidad);
            }
        }catch(Exception e){
            System.out.println("Error  al actualizar \n"+e);
        }
        return correcto;
    }
}

/*

"SELECT *" +
                "FROM sub_unidad_aprendizaje" +
                "JOIN profesor ON sub_unidad_aprendizaje.id_profesor = profesor.id_profesor" +
                "JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje" +
                "WHERE unidad_aprendizaje.nombre = 'Algoritmos y Estructuras de Datos';"


"SELECT profesor.id_profesor,profesor.nombre, profesor.apellido, unidad_aprendizaje.nombre FROM profesor "
                        + "JOIN sub_unidad_aprendizaje ON  profesor.id_usuario = sub_unidad_aprendizaje.id_usuario"
                        + "JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje"
                        + "WHERE unidad_aprendizaje.nombre = "+nombre_unidad_aprendizaje+";"
*/