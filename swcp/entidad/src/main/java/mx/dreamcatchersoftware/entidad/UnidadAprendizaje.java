/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadAprendizaje.findAll", query = "SELECT u FROM UnidadAprendizaje u")
    , @NamedQuery(name = "UnidadAprendizaje.findByIdUnidadAprendizaje", query = "SELECT u FROM UnidadAprendizaje u WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje")
    , @NamedQuery(name = "UnidadAprendizaje.findByNombre", query = "SELECT u FROM UnidadAprendizaje u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasClase", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasTaller", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasLaboratorio", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_unidad_aprendizaje")
    private Integer idUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horas_clase")
    private int horasClase;
    @Basic(optional = false)
    @Column(name = "horas_taller")
    private int horasTaller;
    @Basic(optional = false)
    @Column(name = "horas_laboratorio")
    private int horasLaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadAprendizaje")
    private Collection<SubUnidadAprendizaje> subUnidadAprendizajeCollection;

    public UnidadAprendizaje() {
    }

    public UnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public UnidadAprendizaje(Integer idUnidadAprendizaje, String nombre, int horasClase, int horasTaller, int horasLaboratorio) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombre = nombre;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public Collection<SubUnidadAprendizaje> getSubUnidadAprendizajeCollection() {
        return subUnidadAprendizajeCollection;
    }

    public void setSubUnidadAprendizajeCollection(Collection<SubUnidadAprendizaje> subUnidadAprendizajeCollection) {
        this.subUnidadAprendizajeCollection = subUnidadAprendizajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadAprendizaje != null ? idUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAprendizaje)) {
            return false;
        }
        UnidadAprendizaje other = (UnidadAprendizaje) object;
        if ((this.idUnidadAprendizaje == null && other.idUnidadAprendizaje != null) || (this.idUnidadAprendizaje != null && !this.idUnidadAprendizaje.equals(other.idUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.UnidadAprendizaje[ idUnidadAprendizaje=" + idUnidadAprendizaje + " ]";
    }
    
}
