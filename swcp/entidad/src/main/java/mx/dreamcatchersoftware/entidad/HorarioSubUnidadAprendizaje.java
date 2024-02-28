/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "horario_sub_unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioSubUnidadAprendizaje.findAll", query = "SELECT h FROM HorarioSubUnidadAprendizaje h")
    , @NamedQuery(name = "HorarioSubUnidadAprendizaje.findByIdhorarioSubUnidadAprendizaje", query = "SELECT h FROM HorarioSubUnidadAprendizaje h WHERE h.idhorarioSubUnidadAprendizaje = :idhorarioSubUnidadAprendizaje")
    , @NamedQuery(name = "HorarioSubUnidadAprendizaje.findByClaveDia", query = "SELECT h FROM HorarioSubUnidadAprendizaje h WHERE h.claveDia = :claveDia")
    , @NamedQuery(name = "HorarioSubUnidadAprendizaje.findByHoraInicio", query = "SELECT h FROM HorarioSubUnidadAprendizaje h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioSubUnidadAprendizaje.findByHoraFinal", query = "SELECT h FROM HorarioSubUnidadAprendizaje h WHERE h.horaFinal = :horaFinal")})
public class HorarioSubUnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorario_sub_unidad_aprendizaje")
    private Integer idhorarioSubUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "clave_dia")
    private String claveDia;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_final")
    @Temporal(TemporalType.TIME)
    private Date horaFinal;
    @JoinColumn(name = "id_sub_unidad_aprendizaje", referencedColumnName = "id_sub_unidad_aprendizaje")
    @ManyToOne(optional = false)
    private SubUnidadAprendizaje idSubUnidadAprendizaje;

    public HorarioSubUnidadAprendizaje() {
    }

    public HorarioSubUnidadAprendizaje(Integer idhorarioSubUnidadAprendizaje) {
        this.idhorarioSubUnidadAprendizaje = idhorarioSubUnidadAprendizaje;
    }

    public HorarioSubUnidadAprendizaje(Integer idhorarioSubUnidadAprendizaje, String claveDia, Date horaInicio, Date horaFinal) {
        this.idhorarioSubUnidadAprendizaje = idhorarioSubUnidadAprendizaje;
        this.claveDia = claveDia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public Integer getIdhorarioSubUnidadAprendizaje() {
        return idhorarioSubUnidadAprendizaje;
    }

    public void setIdhorarioSubUnidadAprendizaje(Integer idhorarioSubUnidadAprendizaje) {
        this.idhorarioSubUnidadAprendizaje = idhorarioSubUnidadAprendizaje;
    }

    public String getClaveDia() {
        return claveDia;
    }

    public void setClaveDia(String claveDia) {
        this.claveDia = claveDia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public SubUnidadAprendizaje getIdSubUnidadAprendizaje() {
        return idSubUnidadAprendizaje;
    }

    public void setIdSubUnidadAprendizaje(SubUnidadAprendizaje idSubUnidadAprendizaje) {
        this.idSubUnidadAprendizaje = idSubUnidadAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorarioSubUnidadAprendizaje != null ? idhorarioSubUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioSubUnidadAprendizaje)) {
            return false;
        }
        HorarioSubUnidadAprendizaje other = (HorarioSubUnidadAprendizaje) object;
        if ((this.idhorarioSubUnidadAprendizaje == null && other.idhorarioSubUnidadAprendizaje != null) || (this.idhorarioSubUnidadAprendizaje != null && !this.idhorarioSubUnidadAprendizaje.equals(other.idhorarioSubUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.HorarioSubUnidadAprendizaje[ idhorarioSubUnidadAprendizaje=" + idhorarioSubUnidadAprendizaje + " ]";
    }
    
}
