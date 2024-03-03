/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import mx.dreamcatchersoftware.entidad.HorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Usuario;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
         // Prueba Insertar Usuario
        /*Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        usuario.setCorreo("leonardo.alvarado@uabc.edu.mx");
        usuario.setContrasena("lscleonardo");
        usuario.setPermiso("1");
        boolean ya = ServiceFacadeLocator.getInstanceFacadeUsuario().insertUsario(usuario);
        System.out.println("Insertado: "+ya);*/
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
        
        /*List<Object[]> prof =ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores();
        System.out.println("Unidades Academicas"+prof.get(0)[prof.get(0).length-1]);
        System.out.println("TODO\n");
        if (prof != null) {            
            prof.forEach((sua) -> {
                System.out.println(Arrays.toString(sua) + "\n");
            });
        } else {
            System.out.println("La lista de subunidades de aprendizaje es nula.");
        }*/
        // Probar mostrar profesor y sus unidades de aprendizaje
        /*List<String[]> prof = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesoresUnidadAprendizaje();
        for(String[] p: prof){
            System.out.println(""+Arrays.toString(p));
        }*/        
        // Busqueda de profesor por unidad aprendizaje
        /*List<String[]> prof = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesoresxUnidadAprendizaje("Algoritmos");
        for(String[] p: prof){
            System.out.println(""+Arrays.toString(p));
        }*/
        /*UnidadAprendizaje u =  ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultIdUnidadAprendizaje("11111");
        System.out.println(""+u.getNombre());*/
        // Probar mostrar Sub unidades aprendizaje por id_profesor
        /*List<String[]> subunidad = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizajeIdProfesor("1568");
        for(String[] p: subunidad){
            System.out.println(""+Arrays.toString(p));
        }*/
        
        //Probar consult horario por busqueda profesor
        /*List<String[]> horario = ServiceFacadeLocator.getInstanceFacadeHorarioSubUnidadAprendizaje().consultHorario("456789");
        for(String[] p: horario){
            System.out.println(""+Arrays.toString(p));
        }*/
        // Probar delete profesor
        /*boolean borrado = ServiceFacadeLocator.getInstanceFacadeProfesor().deleteProfesorIdProfesor("123");
        System.out.println("BORRADO: "+borrado);*/
        // Probar insert horario TODAVIA NO ESTA
        // Crear un objeto de tipo HorarioSubUnidadAprendizaje
        /*HorarioSubUnidadAprendizaje horario = new HorarioSubUnidadAprendizaje();
        
        // Llenar los campos del objeto
        horario.setIdhorarioSubUnidadAprendizaje(8);
        horario.setIdhorarioSubUnidadAprendizaje(1); // Asignar un valor al ID
        horario.setClaveDia("1"); // Asignar el día de la semana
        horario.setIdSubUnidadAprendizaje(new SubUnidadAprendizaje()); // Asignar una subunidad de aprendizaje (debe instanciarla adecuadamente)
        
        // Para la hora de inicio y fin, necesitas convertir un String a un objeto Date
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // Formato para la hora
        try {
            // Convertir el String a Date para la hora de inicio
            Date horaInicio = sdf.parse("23:30:00");
            horario.setHoraInicio(horaInicio);
            
            // Convertir el String a Date para la hora de fin
            Date horaFin = sdf.parse("24:00:00");
            horario.setHoraFinal(horaFin);
        } catch (ParseException e) {
            // Manejar cualquier error de parseo aquí
            e.printStackTrace();
        };
        //boolean b = ServiceFacadeLocator.getInstanceFacadeHorarioSubUnidadAprendizaje().insertHorarioSubUnidadAprendizaje(horario, "456789");
        ServiceFacadeLocator.getInstanceFacadeHorarioSubUnidadAprendizaje().insertHorario(horario);*/
        //System.out.println("HORARIO: "+b);
        // Prueba Update subUnidadAprendizaje
        /*SubUnidadAprendizaje sub = new SubUnidadAprendizaje();
        UnidadAprendizaje unidad = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultIdUnidadAprendizaje("11983");
        sub.setIdSubUnidadAprendizaje(2);
        sub.setIdUnidadAprendizaje(unidad);
        Profesor p = new Profesor();
        p = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID("123123");
        sub.setIdProfesor(p);
        sub.setTipo("Taller");
        ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().updateSubUnidadAprendizajeId_SubUnidadAprendizaje(sub);*/
        // Prueba para insert Unidad Aprendizaje
        UnidadAprendizaje unidad = new UnidadAprendizaje();
        unidad.setIdUnidadAprendizaje(321654);
        unidad.setNombre("Base de Datos");
        unidad.setHorasClase(4);
        unidad.setHorasTaller(0);
        unidad.setHorasLaboratorio(2);
        boolean insertado;
        insertado = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().insertUnidadAprendizaje(unidad);
        System.out.println("UUUUUUUUUU: "+insertado);
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
