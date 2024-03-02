/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.integracion.ServiceLocator;

/**
 *
 * @author acer
 */
public class DelegateProfesor {
    /**
     * Metodo de ejemplo para insertar Profesor
     * @param profesor de tipo usuario con id 0 para poder que se cree un id nuevo
     * @return 
     */
    public boolean insertProfesor(Profesor profesor){
        boolean bandera;
        try{
            ServiceLocator.getInstanceProfesorDAO().save(profesor);
            bandera=true;
        }catch(Exception e){
            System.out.println("Error al insertar profesor negocio-delegateProfesor 1");
            System.out.println("\n "+e);
            bandera=false;
        }
        return bandera;
    }

    //Consulta General de profesores
    public List consultProfesores(){
        List<Object[]> profesores = new ArrayList<>();
        List<Object[]> profesoresV = new ArrayList<>();        
        try{
            profesores = ServiceLocator.getInstanceProfesorDAO().executeNoEntity("SELECT * FROM profesor");
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores negocio-delegateProfesor 2");
            System.out.println("\n "+e);            
        }               
        for(Object[] row: profesores){
            List<Object[]> subUnidad = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeNoEntity("SELECT id_unidad_aprendizaje FROM sub_unidad_aprendizaje WHERE id_profesor = "+row[0]+";");
            //System.out.println("SOUT; "+subUnidad.toArray()[1]);
            Object un = subUnidad.toArray()[0];            
            System.out.println("AAA: "+un);
            
            String nombreUnidadesAcademicas = "";            
            String cadenaIdUnidadAprendizaje = subUnidad.toString();                        
            if(subUnidad.size()>1){
                String[] arregloIdDnidadAprendizaje = this.arregloUnidadesAprendizajeID(cadenaIdUnidadAprendizaje);
                for(int x=0;x<arregloIdDnidadAprendizaje.length;x++){
                    //System.out.println("Arreglo: "+arregloIdDnidadAprendizaje[x]);
                    List<Object[]> nombreUn = ServiceLocator.getInstanceUnidadAprendizajeDAO().executeNoEntity("SELECT nombre FROM unidad_aprendizaje WHERE id_unidad_aprendizaje = "+arregloIdDnidadAprendizaje[x]+";");
                    System.out.println("NOMBRES: "+nombreUn.toString());
                    nombreUnidadesAcademicas = nombreUnidadesAcademicas+Arrays.toString(nombreUn.toArray());
                    //Ocupo ir agregando no sobreescribir
                }
                //System.out.println("HOLLLLLLLLLLLLLLLLLLLAAAAAAAA: "+arregloIdDnidadAprendizaje);
            }else{
                System.out.println("AAAADDDDDDDDDDDIIIIIIIIIOOOOOOOSSSSSSS");
                String idUnidadA = subUnidad.toString();
                idUnidadA = idUnidadA.replace("[", "");
                idUnidadA = idUnidadA.replace("]", "");
                idUnidadA = idUnidadA.replace(" ", "");
                List<Object[]> nombreUn = ServiceLocator.getInstanceUnidadAprendizajeDAO().executeNoEntity("SELECT nombre FROM unidad_aprendizaje WHERE id_unidad_aprendizaje = "+idUnidadA+";");
                nombreUnidadesAcademicas = Arrays.deepToString(nombreUn.toArray());
            }
            nombreUnidadesAcademicas = nombreUnidadesAcademicas.replace("][", ", ");
            nombreUnidadesAcademicas = nombreUnidadesAcademicas.replace("[", "");
            nombreUnidadesAcademicas = nombreUnidadesAcademicas.replace("]", "");            
            System.out.println("TIPO:"+subUnidad.toString());
                        
            // Crear un nuevo array para contener los elementos de ambos arrays            
            String unidades = Arrays.deepToString(subUnidad.toArray());            
            unidades = unidades.substring(1, unidades.length() - 1);
            Object[] nuevoArray = new Object[row.length];

            // Copiar los elementos de row al nuevo array
            System.arraycopy(row, 0, nuevoArray, 0, row.length);

            // Copiar los elementos de subUnidad al nuevo array, empezando desde el índice correcto
            //System.arraycopy(subUnidad.toArray(), 0, nuevoArray, row.length, subUnidad.toArray().length);
            nuevoArray[nuevoArray.length-1] = nombreUnidadesAcademicas;
            // Sobrescribir row con el nuevo array
            //System.out.println(Arrays.toString(nuevoArray)+"LINEA");            
            profesoresV.add(nuevoArray);
            /*for (Object element : row) {
                System.out.println(element);
            }
            i++;*/
        }
        
        return profesoresV;
    }
    
    public String[] arregloUnidadesAprendizajeID(String cadena){        
        cadena = cadena.replace("[", "");
        cadena = cadena.replace("]", "");
        cadena = cadena.replace(" ", "");
        String[] retorno = cadena.split(",");
        return retorno;
    }
    
    // Consulta de usuarios por ID
    public Profesor consultProfesorID(int id_profesor){
        Profesor profesor = new Profesor();
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        try{                    
            for(Profesor pf:profesores){
                if(pf.getIdProfesor().toString().equalsIgnoreCase(String.valueOf(id_profesor))){
                    profesor = pf;
                }
            }           
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores por ID  por id negocio-delegateProfesor 3");
            System.out.println("\n "+e);            
        }
        return profesor;
    }
    // Consulta por Nombre y Apellido de Profesor
    public List consultProfesorNomApProfesor(String nombre_profesor, String apellidos_profesor){        
        List<Object[]> profesores = null;
        try{
            profesores =  ServiceLocator.getInstanceProfesorDAO().executeNoEntity("SELECT * FROM profesores WHERE nombre LIKE '%"+nombre_profesor+"%' AND apellido LIKE '%"+apellidos_profesor+"%';");
        }catch(Exception e){
            System.out.println("Error al realizar la consulta de profesores por Nombre y Apellido  por id negocio-delegateProfesor 4");
            System.out.println("\n "+e); 
        }
        
        return profesores;
    }
        
    
    // Eliminar profesores por id
    //PBI - PROF- UH4
  /*  public boolean deleteProfesor(int id_profesor){
        
    }
    */
    // Actualizar datos Profesor
    /*public void updateProfesor(int id_profesor){
        Profesor profesor = new Profesor();
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        for(Profesor pf:profesores){
            if(pf.getIdProfesor().equals(String.valueOf(id_profesor))){               
                profesor = pf;
            }
        }
        
        if(profesor == null || profesor.getIdProfesor() == 0) {
            throw new IllegalArgumentException("Error Actualizar Usuario Code: Negocio-delegateUsuario 2");
        }        
        ServiceLocator.getInstanceProfesorDAO().update(profesor);
    }*/
        
}
