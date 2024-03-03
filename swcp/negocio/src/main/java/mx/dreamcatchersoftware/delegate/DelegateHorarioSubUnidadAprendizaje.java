package mx.dreamcatchersoftware.delegate;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mx.dreamcatchersoftware.entidad.HorarioSubUnidadAprendizaje;
import mx.dreamcatchersoftware.entidad.Profesor;
import mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje;
import mx.dreamcatchersoftware.integracion.ServiceFacadeLocator;
import mx.dreamcatchersoftware.integracion.ServiceLocator;
import java.util.Date;

public class DelegateHorarioSubUnidadAprendizaje {
    
    public void insertHorario(HorarioSubUnidadAprendizaje horario){
        ServiceLocator.getInstanceHorarioSubUnidadAprendizajeDAO().save(horario);
    }
    public boolean insertHorarioSubUnidadAprendizaje(HorarioSubUnidadAprendizaje horario, String id_profesor) {        
        boolean estaEntre = false;
        List<String[]> h = new ArrayList<>();
        try {
            h = ServiceFacadeLocator.getInstanceFacadeHorarioSubUnidadAprendizaje().consultHorario(id_profesor);
            for (String[] ho : h) {                
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date horaInicio = sdf.parse(ho[2]);
                Date horaFin = sdf.parse(ho[3]);
                Date horaInicioC = horario.getHoraInicio();
                Date horaFinC = horario.getHoraFinal();
                estaEntre = horaInicioC.after(horaInicio) && horaFinC.before(horaFin); 
                System.out.println("AHHHHHHHHHHHHHHHHHHH: "+estaEntre);
                if (estaEntre) {
                    // Verifica si el día del horario coincide con el día del profesor
                    if (horario.getClaveDia().equals(ho[1])) {                        
                        break;
                    } else {
                        estaEntre = false;
                    }  
                }
            }    
            System.out.println("UUUUUUUUUUUUUUUUUUU: "+horario.getClaveDia());
            if (estaEntre== false) {
                ServiceLocator.getInstanceHorarioSubUnidadAprendizajeDAO().save(horario);
            }
        } catch(Exception e) {
            System.out.println("Error al insertar profesor negocio-delegateProfesor 1");
            System.out.println("\n "+e);
            estaEntre = false;
        }
        return estaEntre;
    }

    
    public List consultHorarioIdSubUnidadAprendizaje(String id_sub_unidad_aprendizaje){
        List<HorarioSubUnidadAprendizaje> horario = new ArrayList<>();
        try{
            horario = ServiceLocator.getInstanceHorarioSubUnidadAprendizajeDAO().executeQuery("SELECT * FROM horario_sub_unidad_aprendizaje WHERE id_sub_unidad_aprendizaje = "+id_sub_unidad_aprendizaje+";");             
        }catch(Exception e){
            System.out.println("Error al consoultar horar_subUnidad_Aprendizaje negocio-delegateHorarioSubUnidadAprendizaje 1");
            System.out.println("\n "+e);
        }
        return horario;   
    }
    
    // Regrasa una lista de arreglos de String
    public List consultHorario(String id_profesor){
        Profesor prof =  ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(id_profesor);
        List<String[]> subunidadesAprendizaje = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizajeIdProfesor(id_profesor);
        //List<SubUnidadAprendizaje>subunidadAprendizaje= ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeQuery("SELECT * FROM unidad_aprendizaje WHERE id_profesor = "+id_profesor+";");
        List<HorarioSubUnidadAprendizaje> horario = new ArrayList<>();        
        List<String[]> completo = new ArrayList<>();
        for(String[] s:subunidadesAprendizaje){            
            //System.out.println("ididid"+s[0]);
            horario = ServiceFacadeLocator.getInstanceFacadeHorarioSubUnidadAprendizaje().consultHorarioIdSubUnidadAprendizaje(s[0]);
            //System.out.println("HORARIOtipo: "+horario.toString());            
            for(HorarioSubUnidadAprendizaje h: horario){                
                String[] cHorario = new String[8];
                cHorario[0] = ""+h.getIdhorarioSubUnidadAprendizaje();
                cHorario[1] = ""+this.cambiarDiasString(h.getClaveDia());
                cHorario[2] = ""+h.getHoraInicio();
                cHorario[3] = ""+h.getHoraFinal();
                cHorario[4] = s[0];
                cHorario[5] = s[1];
                cHorario[6] = s[2];
                cHorario[7] = s[3];
                
                //System.out.println("UUUUUUUUUUUUUUUUUUU:::::::: "+Arrays.toString(cHorario));
                completo.add(cHorario);
                /*for(String[] m: completo){
                    System.out.println("AXXXXXXXXXXXXXXXXXXXXXXXXXX:::::::: "+Arrays.toString(m));
                }
                System.out.println("------------------------------\n");*/
            }
        }
        
        Collections.sort(completo, new Comparator<String[]>() {
            DelegateHorarioSubUnidadAprendizaje d = new DelegateHorarioSubUnidadAprendizaje();
            @Override
            public int compare(String[] o1, String[] o2) {
                int num1 = d.cambiarDiasInt(o1[1]); 
                int num2 = d.cambiarDiasInt(o2[1]);
                int compareSecond = Integer.compare(num1, num2);
                if (compareSecond != 0) {
                    return compareSecond;
                } else {
                    // Comparar por el tercer elemento (que es de tipo time)
                    // Convertir las cadenas de tiempo a objetos LocalTime
                    LocalTime time1 = LocalTime.parse(o1[2]);
                    LocalTime time2 = LocalTime.parse(o2[2]);
                    return time1.compareTo(time2);
                }
            }
        });
                
        return completo;//subunidadesAprendizaje;
    }
        
    // Esete metodo a diferencia del anterior regresa una lista tipo horario
    public List consultHorarioIdProfesor(String id_profesor){
        Profesor prof =  ServiceFacadeLocator.getInstanceFacadeProfesor().consultProfesorID(id_profesor);
        List<String[]> subunidadesAprendizaje = ServiceFacadeLocator.getInstanceFacadeSubUnidadAprendizaje().consultSubUnidadAprendizajeIdProfesor(id_profesor);
        //List<SubUnidadAprendizaje>subunidadAprendizaje= ServiceLocator.getInstanceSubUnidadAprendizajeDAO().executeQuery("SELECT * FROM unidad_aprendizaje WHERE id_profesor = "+id_profesor+";");
        List<HorarioSubUnidadAprendizaje> horario = new ArrayList<>();                                                
        return horario;//subunidadesAprendizaje;
    }
        
    public String cambiarDiasString(String dia){
        String nombreDia="";
        switch(dia){
            case "1":
                nombreDia="Lunes";
                break;
            case "2":
                nombreDia="Martes";
                break;
            case "3":
                nombreDia="Miercoles";
                break;
            case "4":
                nombreDia="Jueves";
                break;
            case "5":
                nombreDia="Viernes";
                break;
            case "6":
                nombreDia="Sabado";
                break;
        }
        
        return nombreDia;
    }
    
    public int cambiarDiasInt(String dia){
        int claveDia=0;
        switch(dia){
            case "Lunes":
                claveDia= 1;
                break;
            case "Martes":
                claveDia= 2;
                break;
            case "Miercoles":
                claveDia= 3;
                break;
            case "Jueves":
                claveDia= 4;
                break;
            case "Viernes":
                claveDia= 5;
                break;
            case "Sabado":
                claveDia = 6;
                break;
        }
        
        return claveDia;
    }
}
