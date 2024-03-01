package mx.dreamcatchersoftware.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.dreamcatchersoftware.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-29T22:04:47")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> permiso;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile CollectionAttribute<Usuario, Profesor> profesorCollection;

}