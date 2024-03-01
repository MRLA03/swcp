/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

public class DelegateSubUnidadAprendizaje {
    //Consulta General Profesor
    public List consultProfesorUnidadAprendizaje(String nombre_unidad_aprendizaje){ 
        List<Object[]> completo = new ArrayList<>();
        List<Object[]> sub_unidad_aprendizaje = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeNoEntity(
                "SELECT * FROM sub_unidad_aprendizaje;");
       /* List<Object[]> unidad_aprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().executeNoEntity(
                "SELECT * FROM unidad_aprendizaje;");*/
        for(Object[] row: sub_unidad_aprendizaje){
            List<Object[]> profesor = ServiceLocator.getInstanceProfesorDAO().executeNoEntity(
                "SELECT * FROM profesor WHERE id_profesor = "+row[2]+";");            
            List<Object[]> unidad_aprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().executeNoEntity(
                "SELECT nombre FROM unidad_aprendizaje WHERE id_unidad_aprendizaje = "+row[1]+";");              
            System.out.println("UNIDAD"+Arrays.deepToString(profesor.toArray()));
            System.out.println("UNIDAD"+unidad_aprendizaje.toString());
                       
            Object[] nuevoArray = new Object[row.length + unidad_aprendizaje.toArray().length];

            // Copiar los elementos de array1 al nuevo array
            System.arraycopy(row, 0, nuevoArray, 0, row.length);

            // Copiar los elementos de array2 al nuevo array, empezando desde el índice correcto
            System.arraycopy(unidad_aprendizaje.toArray(), 0, nuevoArray, row.length, unidad_aprendizaje.toArray().length);
            
            // Unir prof unAp y row y pasarlo a completo                        
            completo.add(nuevoArray);            
        }
        //+
                //"JOIN profesor ON sub_unidad_aprendizaje.id_profesor = profesor.id_profesor" +
                //"JOIN unidad_aprendizaje ON sub_unidad_aprendizaje.id_unidad_aprendizaje = unidad_aprendizaje.id_unidad_aprendizaje" +
                //"WHERE sub_unidad_aprendizaje.id_sub_unidad_aprendizaje = 1;");
        
        if(sub_unidad_aprendizaje != null){
            System.out.println("NO ESTA VACIA");
        }else{
            System.out.println("VACIA");
        }
        return completo;
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