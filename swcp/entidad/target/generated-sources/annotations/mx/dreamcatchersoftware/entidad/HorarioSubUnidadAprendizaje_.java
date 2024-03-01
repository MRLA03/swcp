package mx.dreamcatchersoftware.entidad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-29T22:04:47")
@StaticMetamodel(HorarioSubUnidadAprendizaje.class)
public class HorarioSubUnidadAprendizaje_ { 

    public static volatile SingularAttribute<HorarioSubUnidadAprendizaje, Integer> idhorarioSubUnidadAprendizaje;
    public static volatile SingularAttribute<HorarioSubUnidadAprendizaje, Date> horaFinal;
    public static volatile SingularAttribute<HorarioSubUnidadAprendizaje, SubUnidadAprendizaje> idSubUnidadAprendizaje;
    public static volatile SingularAttribute<HorarioSubUnidadAprendizaje, String> claveDia;
    public static volatile SingularAttribute<HorarioSubUnidadAprendizaje, Date> horaInicio;

}