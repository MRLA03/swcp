/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Usuario;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateUsuario {
    
    public Usuario login(String password, String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        
        for(Usuario us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        if(usuario == null){
            System.out.println("El usuario No existe");
        }else{
            System.out.println("Se inicio sesión con exito");
        }
        
        return usuario;
    }
    
    /**
     * Metodo para insertar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    //PBI-US-UH1
    public boolean insertUsuario(Usuario usuario){
        Usuario us = new Usuario();
        boolean bandera = true;
        try{
            us = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosCorreoCompleto(usuario.getCorreo());
            if(us.getCorreo() == ""){
                ServiceLocator.getInstanceUsuarioDAO().save(usuario);
            }else{
                bandera = false;
            }
        }catch(Exception e){
            System.out.println("Error al insertar usuario negocio-delegateUsuario 1");
            System.out.println("\n "+e);
        }
        return bandera;
    }
    /*
        Método de para actualizar Usuario
    */
    //PBI-US-UH2
    public boolean updateUsuario(String correo, String contrasena){
        boolean bandera = true;
        Usuario usuario = new Usuario();                               
        /*for(Usuario us:usuarios){
            if(us.getCorreo().equalsIgnoreCase(correo)){
                us.setContrasena(contrasena);
                usuario = us;
            }
        }*/
                  
        try{
            usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().consultUsuariosCorreoCompleto(correo);
            if(usuario.getCorreo()==""){
                usuario.setContrasena(contrasena);
                ServiceLocator.getInstanceUsuarioDAO().update(usuario);   
            }else{
                bandera = false;
            }
        }catch(Exception e){
            System.out.println("Error Actualizar Usuario Code: Negocio-delegateUsuario 2\n"+e);
        }  
        return bandera;
    }
    
    // Consulta General de Usuarios
    // PBI- PROF- UH1
    public List consultUsuarios(){
        List<Usuario> usuarios = null;
        try{
            usuarios = ServiceLocator.getInstanceUsuarioDAO().executeQuery("SELECT * FROM usuario;");//ServiceLocator.getInstanceUsuarioDAO().findAll();
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario negocio-delegateUsuario 3");
            System.out.println("\n "+e);            
        }
        return usuarios;
    }
    // Consulta de usuarios por id
    // PBI- PROF- UH1
    // Consulta de usuarios por correo
    // PBI- PROF- UH1
    public Usuario consultUsuariosCorreoCompleto(String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        try{
            usuarios = ServiceLocator.getInstanceUsuarioDAO().executeQuery("SELECT * FROM usuario WHERE correo = "+correo+";");
        
            for(Usuario us:usuarios){                
                    usuario = us;                
            }           
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario por correo completo negocio-delegateUsuario 5");
            System.out.println("\n "+e);            
        }
        return usuario;
    }
    
    // Consulta de usuarios por permiso
    public List consultUsuariosPermiso(String permiso){        
        List<Usuario> usuarios = null;
        try{                    
            usuarios = ServiceLocator.getInstanceUsuarioDAO().executeQuery("SELECT * FROM usuario WHERE permiso = '"+permiso+"';");
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario por permiso completo negocio-delegateUsuario 6");
            System.out.println("\n "+e);            
        }
        return usuarios;
    }
    /*
    
    List<Usuario> usuarios = null;
        try{
            usuarios = ServiceLocator.getInstanceUsuarioDAO().executeQuery("SELECT * FROM usuario WHERE correo ="+correo);   
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
        
    */
}
