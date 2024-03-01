/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

public class DelegateSubUnidadAprendizaje {
    
    public List consultProfesorUnidadAprendizaje(String nombre_unidad_aprendizaje){
        List<Profesor> sub_unidad_aprendizaje = ServiceLocator.getInstanceProfesorDAO().executeQuery(
                "SELECT *" +
                "FROM sub_unidad_aprendizaje" +
                "JOIN profesor ON sub_unidad_aprendizaje.id_profesor = profesor.id_profesor" +
                "JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje" +
                "WHERE unidad_aprendizaje.nombre = 'Algoritmos y Estructuras de Datos';");
        
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


"SELECT profesor.id_profesor,profesor.nombre, profesor.apellido, unidad_aprendizaje.nombre FROM profesor "
                        + "JOIN sub_unidad_aprendizaje ON  profesor.id_usuario = sub_unidad_aprendizaje.id_usuario"
                        + "JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje"
                        + "WHERE unidad_aprendizaje.nombre = "+nombre_unidad_aprendizaje+";"
*/