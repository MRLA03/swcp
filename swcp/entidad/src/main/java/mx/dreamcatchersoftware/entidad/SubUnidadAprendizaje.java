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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sub_unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubUnidadAprendizaje.findAll", query = "SELECT s FROM SubUnidadAprendizaje s")
    , @NamedQuery(name = "SubUnidadAprendizaje.findByIdSubUnidadAprendizaje", query = "SELECT s FROM SubUnidadAprendizaje s WHERE s.idSubUnidadAprendizaje = :idSubUnidadAprendizaje")
    , @NamedQuery(name = "SubUnidadAprendizaje.findByTipo", query = "SELECT s FROM SubUnidadAprendizaje s WHERE s.tipo = :tipo")})
public class SubUnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_unidad_aprendizaje")
    private Integer idSubUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor")
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @JoinColumn(name = "id_unidad_aprendizaje", referencedColumnName = "id_unidad_aprendizaje")
    @ManyToOne(optional = false)
    private UnidadAprendizaje idUnidadAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubUnidadAprendizaje")
    private Collection<HorarioSubUnidadAprendizaje> horarioSubUnidadAprendizajeCollection;

    public SubUnidadAprendizaje() {
    }

    public SubUnidadAprendizaje(Integer idSubUnidadAprendizaje) {
        this.idSubUnidadAprendizaje = idSubUnidadAprendizaje;
    }

    public SubUnidadAprendizaje(Integer idSubUnidadAprendizaje, String tipo) {
        this.idSubUnidadAprendizaje = idSubUnidadAprendizaje;
        this.tipo = tipo;
    }

    public Integer getIdSubUnidadAprendizaje() {
        return idSubUnidadAprendizaje;
    }

    public void setIdSubUnidadAprendizaje(Integer idSubUnidadAprendizaje) {
        this.idSubUnidadAprendizaje = idSubUnidadAprendizaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public UnidadAprendizaje getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(UnidadAprendizaje idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    @XmlTransient
    public Collection<HorarioSubUnidadAprendizaje> getHorarioSubUnidadAprendizajeCollection() {
        return horarioSubUnidadAprendizajeCollection;
    }

    public void setHorarioSubUnidadAprendizajeCollection(Collection<HorarioSubUnidadAprendizaje> horarioSubUnidadAprendizajeCollection) {
        this.horarioSubUnidadAprendizajeCollection = horarioSubUnidadAprendizajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubUnidadAprendizaje != null ? idSubUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubUnidadAprendizaje)) {
            return false;
        }
        SubUnidadAprendizaje other = (SubUnidadAprendizaje) object;
        if ((this.idSubUnidadAprendizaje == null && other.idSubUnidadAprendizaje != null) || (this.idSubUnidadAprendizaje != null && !this.idSubUnidadAprendizaje.equals(other.idSubUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.SubUnidadAprendizaje[ idSubUnidadAprendizaje=" + idSubUnidadAprendizaje + " ]";
    }
    
}
