/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.facade;

import java.util.List;
import mx.dreamcatchersoftware.delegate.DelegateUsuario;
import mx.dreamcatchersoftware.entidad.Usuario;

public class FacadeUsuario {
    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }
        
    public Usuario login(String password, String correo){
        return delegateUsuario.login(password, correo);
    }
    
    public boolean insertUsario(Usuario usuario){
        return delegateUsuario.insertUsuario(usuario);
    }
    
    public void updateUsuario(String correo, String contrasena){
        delegateUsuario.updateUsuario(correo, contrasena);
    }
    
    public List consultUsuarios(){
        return delegateUsuario.consultUsuarios();
    }
    
    /*public Usuario consultUsuariosID(int id_usuario){
        return delegateUsuario.consultUsuariosID(id_usuario);
    }*/
    
    public Usuario consultUsuariosCorreoCompleto(String correo){
        return delegateUsuario.consultUsuariosCorreoCompleto(correo);
    }
    
    public List consultUsuariosPermiso(String permiso){
        return delegateUsuario.consultUsuariosPermiso(permiso);
    }
}
