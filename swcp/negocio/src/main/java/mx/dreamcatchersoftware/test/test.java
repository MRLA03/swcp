/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        /* // Prueba Insertar Usuario
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setCorreo("leonardo.alvarado@uabc.edu.mx");
        usuario.setContrasena("lscleonardo");
        usuario.setPermiso("1");
        ServiceFacadeLocator.getInstanceFacadeUsuario().insertUsario(usuario);*/
        // Prueba Actualizar Contraseña de usuario
        //ServiceFacadeLocator.getInstanceFacadeUsuario().updateUsuario("leonardo.alvarado@uabc.edu.mx", "lsc2024");
        
        // Prueba para Insertar Profesor
        /*Usuario usuario = new Usuario();
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosCorreoCompleto("leonardo.alvarado@uabc.edu.mx");
        
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(1568);
        profesor.setNombre("Leonardo Alberto");
        profesor.setApellido("Alvarado Aguila");
        profesor.setRfc("AALA0205036h621");
        profesor.setIdUsuario(usuario);
        ServiceFacadeLocator.getInstanceFacadeProfesor().insertProfesor(profesor);*/
        /*
        // Prueba para mostrar Usuarios
        List<Object[]> usuarios = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuarios();
        if (usuarios != null) {
            usuarios.forEach((sua) -> {
                System.out.println(Arrays.toString(sua) + "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }    */    
        /*List<Object[]> subUnidadesAprendizaje = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultProfesorUnidadAprendizaje("Algoritmos y Estructuras de Datos");
        subUnidadesAprendizaje.forEach(new Consumer<Object[]>() {
            @Override
            public void accept(Object[] row) {
                //List<Object[]> profesor = ServiceLocator.getInstanceProfesorDAO().executeNoEntity(
                //"SELECT * FROM profesor WHERE id_profesor = "+row[1].+"";");
                System.out.println(""+Arrays.toString(row));
            }
        });
        if (subUnidadesAprendizaje != null) {
        subUnidadesAprendizaje.forEach((sua) -> {
        System.out.println(Arrays.toString(sua) + "\n");
        });
        } else {
        System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
        
        List<Object[]> prof =ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores();
        System.out.println("Unidades Academicas"+prof.get(0)[prof.get(0).length-1]);
        System.out.println("TODO\n");
        if (prof != null) {            
            prof.forEach((sua) -> {
                System.out.println(Arrays.toString(sua) + "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }
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
