package mx.dreamcatchersoftware.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.dreamcatchersoftware.entidad.HorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-29T22:04:47")
@StaticMetamodel(SubUnidadAprendizaje.class)
public class SubUnidadAprendizaje_ { 

    public static volatile SingularAttribute<SubUnidadAprendizaje, String> tipo;
    public static volatile SingularAttribute<SubUnidadAprendizaje, UnidadAprendizaje> idUnidadAprendizaje;
    public static volatile SingularAttribute<SubUnidadAprendizaje, Profesor> idProfesor;
    public static volatile CollectionAttribute<SubUnidadAprendizaje, HorarioSubUnidadAprendizaje> horarioSubUnidadAprendizajeCollection;
    public static volatile SingularAttribute<SubUnidadAprendizaje, Integer> idSubUnidadAprendizaje;

}