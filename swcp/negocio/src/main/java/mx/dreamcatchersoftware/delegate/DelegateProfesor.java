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
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.UnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;
import java.util.Collections;
import java.util.Comparator;
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
    /*public List consultProfesores(){
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
            i++;
        }
        
        return profesoresV;
    }*/
    
    public List consultProfesores(){
        return ServiceLocator.getInstanceProfesorDAO().findAll();
    }
    public List consultProfesoresUnidadAprendizaje(){
        List<String[]> completo = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores());
        List<SubUnidadAprendizaje> subunidadaprendizaje = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizaje());        
        Collections.sort(profesores, Comparator.comparing(Profesor::getNombre));
        for(Profesor profesor: profesores){
            String[] cadena = new String[6];
            cadena[0] = ""+profesor.getIdProfesor();
            cadena[1] = ""+profesor.getNombre();
            cadena[2] = ""+profesor.getApellido();
            cadena[3] = ""+profesor.getRfc();  
            String unidades="";
            for(SubUnidadAprendizaje s: subunidadaprendizaje){                     
                if(s.getIdProfesor().equals(profesor)){                                       
                       if(unidades==""){
                           unidades =  unidades + s.getIdUnidadAprendizaje().getNombre();
                       }else{
                           unidades =  unidades +", "+s.getIdUnidadAprendizaje().getNombre();
                       }
                }
            }
            cadena[4] = ""+profesor.getIdUsuario().getCorreo();
            cadena[5] = ""+unidades;
            completo.add(cadena);            
        }        
        return completo;
    }
    
    public List consultProfesoresxUnidadAprendizaje(String unidad_aprendizaje){
        List<String[]> completo = new ArrayList<>();
        SubUnidadAprendizaje sub = new SubUnidadAprendizaje();
        List<SubUnidadAprendizaje> subunidadaprendizaje = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizaje();
        //List<Profesor> profesores = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesores());
        List<UnidadAprendizaje> unidadesA = ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().consultNombreUnidadAprendizaje(unidad_aprendizaje);
        List<String> id_profesor =  new ArrayList<>();
        for(UnidadAprendizaje un: unidadesA){
            sub = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizajeIdUnidadAprendizaje(""+un.getIdUnidadAprendizaje());
            //System.out.println("UUUUUUUUUUUUUUUUUUUUUAAAAAAAAAAAAAAA"+un.getNombre());
            id_profesor.add(""+sub.getIdProfesor().getIdProfesor());
        }
        List<Profesor> profesores = new ArrayList<>();
        for(String s: id_profesor){
            Profesor pr =  new Profesor();
            pr = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(s);
            //System.out.println("PROF: "+pr.getNombre());
            profesores.add(pr);
        }
        //subunidadaprendizaje = new ArrayList<>(ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizaje());                        

        Collections.sort(profesores, Comparator.comparing(Profesor::getNombre));
        for(Profesor profesor: profesores){
            String[] cadena = new String[5];
            cadena[0] = ""+profesor.getIdProfesor();
            cadena[1] = ""+profesor.getNombre();
            cadena[2] = ""+profesor.getApellido();
            cadena[3] = ""+profesor.getRfc();  
            String unidades="";
            for(SubUnidadAprendizaje s: subunidadaprendizaje){                     
                if(s.getIdProfesor().equals(profesor)){                                       
                       if(unidades==""){
                           unidades =  unidades + s.getIdUnidadAprendizaje().getNombre();
                       }else{
                           unidades =  unidades +", "+s.getIdUnidadAprendizaje().getNombre();
                       }
                }
            }
            cadena[4] = ""+unidades;
            completo.add(cadena);            
        }        
        return completo;
    }
    
    public String[] arregloUnidadesAprendizajeID(String cadena){        
        cadena = cadena.replace("[", "");
        cadena = cadena.replace("]", "");
        cadena = cadena.replace(" ", "");
        String[] retorno = cadena.split(",");
        return retorno;
    }
    
    //PENDIENTE
    public boolean deleteProfesorIdProfesor(String id_profesor){
        boolean bandera = true;
        List<Profesor> profesor = null;
        List<SubUnidadAprendizaje> subunidad = null;
        try{
            subunidad = ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeQuery(" SELECT *  FROM sub_unidad_aprendizaje WHERE id_profesor ="+id_profesor+";");
            if(subunidad.size() != 0){
                ServiceLocator.getInstanceProfesorDAO().executeQuery("DELETE FROM sub_unidad_aprendizaje WHERE id_profesor ="+id_profesor+";");
            }
            profesor = ServiceLocator.getInstanceProfesorDAO().executeQuery(" SELECT *  FROM profesor WHERE id_profesor ="+id_profesor+";");
            if(profesor.size() != 0){
                ServiceLocator.getInstanceProfesorDAO().delete(ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(id_profesor));
            }else{
                bandera = false;
            }
            profesor = null;
            profesor = ServiceLocator.getInstanceProfesorDAO().executeQuery(" SELECT *  FROM profesor WHERE id_profesor ="+id_profesor+";");
            if(profesor.size() == 0){
                bandera = true;
            }
        }catch(Exception e){
            System.out.println("Error al realizar el delete de profesor por id negocio-delegateProfesor 5");
            System.out.println("\n "+e); 
        }
        return bandera;
    }
    // Consulta de usuarios por ID
    public Profesor consultProfesorID(String id_profesor){
        Profesor profesor = new Profesor();
        List<Profesor> profesores;//= ServiceLocator.getInstanceProfesorDAO().findAll();
        try{      
            profesores = ServiceLocator.getInstanceProfesorDAO().executeQuery("SELECT * FROM profesor WHERE id_profesor = "+id_profesor+";");
            for(Profesor p: profesores){
                profesor =  p;
            }
            /*
            for(Profesor pf:profesores){
                if(pf.getIdProfesor().toString().equalsIgnoreCase(String.valueOf(id_profesor))){
                    profesor = pf;
                }
            }    */       
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
        
    public void uptdateProfesor(Profesor prof){
        try{
            Profesor p = ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(prof.getIdProfesor().toString());
            if(p.getIdProfesor() != null){
                ServiceLocator.getInstanceProfesorDAO().update(prof);
            }
        }catch(Exception e){
            System.out.println("Error al actualizar el profesor\n"+e);
        }
    
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
