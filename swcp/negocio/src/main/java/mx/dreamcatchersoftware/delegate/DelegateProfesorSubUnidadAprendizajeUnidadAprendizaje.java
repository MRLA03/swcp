/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.ProfesorSubUnidadAprendizajeUnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateProfesorSubUnidadAprendizajeUnidadAprendizaje {
    
    public List consultProfesorUnidadAprendizaje(String nombre_unidad_aprendizaje){
        List<ProfesorSubUnidadAprendizajeUnidadAprendizaje> sub_unidad_aprendizaje = ServiceLocator.getInstanceProfesorSubUnidadAprendizajeUnidadAprendizajeDAO().executeQuery(
                "SELECT *" +
                "FROM sub_unidad_aprendizaje" +                
                "WHERE sub_unidad_aprendizaje.id_sub_unidad_aprendizaje = 1;");
        
        if(sub_unidad_aprendizaje != null){
            System.out.println("NO ESTA VACIA");
        }else{
            System.out.println("VACIA");
        }
        return sub_unidad_aprendizaje;
        //profesor.id_profesor,profesor.nombre, profesor.apellido, unidad_aprendizaje.nombre
    }
}

/*
"SELECT *" +
                "FROM sub_unidad_aprendizaje" +
                "JOIN profesor ON sub_unidad_aprendizaje.id_profesor = profesor.id_profesor" +
                "JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje" +
                "WHERE unidad_aprendizaje.nombre = 'Algoritmos y Estructuras de Datos';"
*/
