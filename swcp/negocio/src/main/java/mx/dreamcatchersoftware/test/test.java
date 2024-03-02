/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.test;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.ProfesorSubUnidadAprendizajeUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Usuario;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        // PRUEBA INSERTAR USUARIO
        /*Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setCorreo("leonardo.alvarado@uabc.edu.mx");
        usuario.setContrasena("lscleonardo");
        usuario.setPermiso("1");
        ServiceFacadeLocator.getInstanceFacadeUsuario().insertUsario(usuario);*/
        
        // PRUEBA ACTUALIZAR CONTRASEÑA USUARIO
        /*ServiceFacadeLocator.getInstanceFacadeUsuario().updateUsuario("leonardo.alvarado@uabc.edu.mx", "lsc2024");*/
        
        // PRUEBA INICIO DE SESION
        /*ServiceFacadeLocator.getInstanceFacadeUsuario().login("lsc2024", "leonardo.alvarado@uabc.edu.mx");*/
        
        // PRUEBA CONSULTA GENERAL USUARIOS
        /*List<Usuario> usuarios = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuarios());
        for (Usuario usuario : usuarios) {
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Contrasena: " + usuario.getContrasena());
            System.out.println("Permisos: " + usuario.getPermiso());
            // Agrega más campos según la estructura de tu objeto Usuario
            System.out.println("-------------------------------------");
        }*/
        
        // PRUEBA CONSULTA ESPECIFICA USUARIO POR CORREO
        /*Usuario usuario = new Usuario();
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosCorreoCompleto("leonardo.alvarado@uabc.edu.mx");
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contrasena: " + usuario.getContrasena());
        System.out.println("Permisos: " + usuario.getPermiso());
        // Agrega más campos según la estructura de tu objeto Usuario
        System.out.println("-------------------------------------");*/
        
        // PRUEBA CONSULTA ESPECIFICA USUARIO POR ID
        /*Usuario usuario = new Usuario();
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosID(1);
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Contrasena: " + usuario.getContrasena());
        System.out.println("Permisos: " + usuario.getPermiso());
        // Agrega más campos según la estructura de tu objeto Usuario
        System.out.println("-------------------------------------");*/
        
        //PRUEBA INSERTAR PROFESOR
        //List<Profesor> profesores = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores());       
        /*Profesor profesor = new Profesor();
        profesor.setIdProfesor(1568);
        profesor.setNombre("Leonardo Alberto");
        profesor.setApellido("Alvarado Aguila");
        profesor.setRfc("AALA0205036h621");
        profesor.setIdUsuario(usuario);
        ServiceFacadeLocator.getInstanceFacadeProfesor().insertProfesor(profesor);*/
        
        
        //PRUEBA DE INSERTAR UNIDAD DE APRENDIZAJE
        //UnidadAprendizaje unidadaprendizaje = new UnidadAprendizaje();
        /*unidadaprendizaje.setIdUnidadAprendizaje(3);
        unidadaprendizaje.setNombre("Computacion");
        unidadaprendizaje.setHorasClase(1);
        unidadaprendizaje.setHorasTaller(1);
        unidadaprendizaje.setHorasLaboratorio(1);
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().insertUnidadAprendizaje(unidadaprendizaje);*/
        
        //CONSULTA ESPECIFICA UNIDAD DE APRENDIZAJE
        /*unidadaprendizaje=ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultUnidadAprendizaje(1);
        System.out.println("hola: "+unidadaprendizaje.getNombre());*/
        
        //Prueba insertar SubUnidadAprendizaje
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
        
        
        
        //NO SIRVE        
        /*List<ProfesorSubUnidadAprendizajeUnidadAprendizaje> profesores = ServiceFacadeLocator.getInstanceFacadeProfesorSubUnidadAprendizajeUnidadAprendizaje().consultProfesorUnidadAprendizaje("Algoritmos y Estructuras de Datos");
        if (profesores != null) {
            for (ProfesorSubUnidadAprendizajeUnidadAprendizaje sua : profesores) {
                System.out.println(sua.getProfesor().getNombre()+ "\n");
            }
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/        
    }
}