/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delgate;

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
        
        for(Usuario us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        return usuario;
    }
    
    /**
     * Metodo de ejemplo para insertar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void insertUsuario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
    
    public void updateUsuario(Usuario usuarios){
        Usuario usuario = new Usuario();
        if(usuario == null || usuario.getIdUsuario() == 0) {
            throw new IllegalArgumentException("Error Actualizar Alumno Code: Negocio-Delegate");
        }
        
    }
}
