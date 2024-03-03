/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.test;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.ProfesorSubUnidadAprendizajeUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Usuario;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        /* // Prueba Insertar Usuario
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setCorreo("leonardo.alvarado@uabc.edu.mx");
        usuario.setContrasena("lscleonardo");
        usuario.setPermiso("1");
=======
        // PRUEBA INSERTAR USUARIO
        /*Usuario usuario = new Usuario();
        usuario.setCorreo("alejandro@uabc.edu.mx");
        usuario.setContrasena("insano");
        usuario.setPermiso("0");
>>>>>>> Stashed changes
        ServiceFacadeLocator.getInstanceFacadeUsuario().insertUsario(usuario);*/
        // Prueba Actualizar Contraseña de usuario
        //ServiceFacadeLocator.getInstanceFacadeUsuario().updateUsuario("leonardo.alvarado@uabc.edu.mx", "lsc2024");
        
        // Prueba para Insertar Profesor
        /*Usuario usuario = new Usuario();
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosCorreoCompleto("leonardo.alvarado@uabc.edu.mx");
        
<<<<<<< Updated upstream
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(1568);
        profesor.setNombre("Leonardo Alberto");
        profesor.setApellido("Alvarado Aguila");
=======
        // PRUEBA CONSULTA ESPECIFICA USUARIO POR ID
        /*Usuario usuario = new Usuario();
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosID(1);
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contrasena: " + usuario.getContrasena());
        System.out.println("Permisos: " + usuario.getPermiso());
        // Agrega más campos según la estructura de tu objeto Usuario
        System.out.println("-------------------------------------");*/
        
        // PRUEBA INSERTAR PROFESOR    
        /*Profesor profesor = new Profesor();
        profesor.setIdProfesor(1569);
        profesor.setNombre("Alejandro");
        profesor.setApellido("Trujillo");
>>>>>>> Stashed changes
        profesor.setRfc("AALA0205036h621");
        profesor.setIdUsuario(ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosID(2));
        ServiceFacadeLocator.getInstanceFacadeProfesor().insertProfesor(profesor);*/
        
<<<<<<< Updated upstream
                
        List<ProfesorSubUnidadAprendizajeUnidadAprendizaje> profesores = ServiceFacadeLocator.getInstanceFacadeProfesorSubUnidadAprendizajeUnidadAprendizaje().consultProfesorUnidadAprendizaje("Algoritmos y Estructuras de Datos");
        if (profesores != null) {
            for (ProfesorSubUnidadAprendizajeUnidadAprendizaje sua : profesores) {
                System.out.println(sua.getProfesor().getNombre()+ "\n");
            }
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }
=======
        // PRUEBA ELIMINAR PROFESOR
        //ServiceFacadeLocator.getInstanceFacadeProfesor().deleteProfesor(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(1569));
        
        // PRUEBA CONSULTA GENERAL PROFESOR, SOLO DATOS DE PROFESOR
        /*List<Profesor> profesores = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores());           
        for (Profesor profesor : profesores) {
            System.out.println("ID: " + profesor.getIdProfesor());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Apellido: " + profesor.getApellido());
            System.out.println("RFC: "+profesor.getRfc());
            // Agrega más campos según la estructura de tu objeto Usuario
            System.out.println("-------------------------------------");        
        }*/
        
        // PRUEBA DE INSERTAR UNIDAD DE APRENDIZAJE
        //UnidadAprendizaje unidadaprendizaje = new UnidadAprendizaje();
        /*unidadaprendizaje.setIdUnidadAprendizaje(3);
        unidadaprendizaje.setNombre("Computacion");
        unidadaprendizaje.setHorasClase(1);
        unidadaprendizaje.setHorasTaller(1);
        unidadaprendizaje.setHorasLaboratorio(1);
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().insertUnidadAprendizaje(unidadaprendizaje);*/
        
        // CONSULTA ESPECIFICA UNIDAD DE APRENDIZAJE
        /*unidadaprendizaje=ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultUnidadAprendizaje(1);
        System.out.println("hola: "+unidadaprendizaje.getNombre());*/
        
        // PRUEBA INSERTAR SUB UNIDAD APRENDIZAJE
        /*SubUnidadAprendizaje subunidadaprendizaje = new SubUnidadAprendizaje();
        subunidadaprendizaje.setIdUnidadAprendizaje(ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultUnidadAprendizaje(4));
        subunidadaprendizaje.setIdProfesor(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(1568));
        subunidadaprendizaje.setTipo("Clase");
        ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().insertSubUnidadAprendizaje(subunidadaprendizaje);*/

        /*List<Profesor> profesores = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores());
        List<SubUnidadAprendizaje> subunidadesaprendizaje = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizaje());
        for (Profesor profesor : profesores) {
            System.out.println("ID: " + profesor.getIdProfesor());
            System.out.println("Nombre: " + profesor.getNombre());
            System.out.println("Apellido: " + profesor.getApellido());
            System.out.println("RFC: "+profesor.getRfc());
            for(SubUnidadAprendizaje subunidadaprendizaje : subunidadesaprendizaje){
                if(subunidadaprendizaje.getIdProfesor().equals(profesor)){
                    System.out.println("Unidades de aprendizaje asignadas: "+subunidadaprendizaje.getIdUnidadAprendizaje().getNombre());
                }
            }
            // Agrega más campos según la estructura de tu objeto Usuario
            System.out.println("-------------------------------------");
        }*/  
>>>>>>> Stashed changes
    }
}

/*

Usuario usuario = new Usuario();
        
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().login("contra123","francisco.reyes.parra@uabc.edu.mx");
        
        if(usuario.getIdusuario() != null){
            System.out.println("Login exitoso con el correo: " + usuario.getCorreo());
        }else{
            System.out.println("No se encontro registro");
        }

*/
