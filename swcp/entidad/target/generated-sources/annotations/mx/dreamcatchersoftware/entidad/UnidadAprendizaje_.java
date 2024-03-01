package mx.dreamcatchersoftware.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-29T22:04:47")
@StaticMetamodel(UnidadAprendizaje.class)
public class UnidadAprendizaje_ { 

    public static volatile SingularAttribute<UnidadAprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasLaboratorio;
    public static volatile CollectionAttribute<UnidadAprendizaje, SubUnidadAprendizaje> subUnidadAprendizajeCollection;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasClase;
    public static volatile SingularAttribute<UnidadAprendizaje, String> nombre;
    public static volatile SingularAttribute<UnidadAprendizaje, Integer> horasTaller;

}