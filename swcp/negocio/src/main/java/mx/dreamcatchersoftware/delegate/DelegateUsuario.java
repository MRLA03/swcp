/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.List;
import mx.dreamcatchersoftware.entidad.Usuario;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateUsuario {
    
    public Usuario login(String password, String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        boolean existe = false;
        for(Usuario us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
                existe = true;
            }
        }
        if(existe==false){
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
    public void insertUsuario(Usuario usuario){                    
        try{    
            ServiceLocator.getInstanceUsuarioDAO().save(usuario);
        }catch(Exception e){
            System.out.println("Error al insertar usuario negocio-delegateUsuario 1");
            System.out.println("\n "+e);
        }
    }
    /*
        Método de para actualizar Usuario
    */
    //PBI-US-UH2
    public void updateUsuario(String correo, String contrasena){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        for(Usuario us:usuarios){
            if(us.getCorreo().equalsIgnoreCase(correo)){
                us.setContrasena(contrasena);
                usuario = us;
            }
        }
        
        if(usuario == null || usuario.getIdUsuario() == 0) {
            throw new IllegalArgumentException("Error Actualizar Usuario Code: Negocio-delegateUsuario 2");
        }        
        ServiceLocator.getInstanceUsuarioDAO().update(usuario);
    }
    
    // Consulta General de Usuarios
    // PBI- PROF- UH1
    public List consultUsuarios(){
        List<Usuario> usuarios = null;
        try{
            usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario negocio-delegateUsuario 3");
            System.out.println("\n "+e);            
        }
        return usuarios;
    }
    // Consulta de usuarios por id
    // PBI- PROF- UH1
    public Usuario consultUsuariosID(int id_usuario){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        try{
            for(Usuario us:usuarios){
                if(us.getIdUsuario().toString().equalsIgnoreCase(String.valueOf(id_usuario))){
                    usuario = us;
                }
            }           
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de Usuario  por id negocio-delegateUsuario 4");
            System.out.println("\n "+e);            
        }
        return usuario;
    }
    // Consulta de usuarios por correo
    // PBI- PROF- UH1
    public Usuario consultUsuariosCorreoCompleto(String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        try{
            
        
            for(Usuario us:usuarios){
                if(us.getCorreo().equalsIgnoreCase(correo)){
                    usuario = us;
                }
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
