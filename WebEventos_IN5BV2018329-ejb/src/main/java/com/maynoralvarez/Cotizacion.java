/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maynoralvarez;

import java.io.Serializable;
import java.util.List;
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
 * @author programacion
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByIdcotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idcotizacion = :idcotizacion")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcotizacion")
    private Integer idcotizacion;
    @JoinColumn(name = "detallecotizacion_iddetallecotizacion", referencedColumnName = "iddetallecotizacion")
    @ManyToOne(optional = false)
    private Detallecotizacion detallecotizacionIddetallecotizacion;
    @JoinColumn(name = "reservacion_idreservacion", referencedColumnName = "idreservacion")
    @ManyToOne(optional = false)
    private Reservacion reservacionIdreservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacionIdcotizacion")
    private List<Facturacion> facturacionList;

    public Cotizacion() {
    }

    public Cotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Detallecotizacion getDetallecotizacionIddetallecotizacion() {
        return detallecotizacionIddetallecotizacion;
    }

    public void setDetallecotizacionIddetallecotizacion(Detallecotizacion detallecotizacionIddetallecotizacion) {
        this.detallecotizacionIddetallecotizacion = detallecotizacionIddetallecotizacion;
    }

    public Reservacion getReservacionIdreservacion() {
        return reservacionIdreservacion;
    }

    public void setReservacionIdreservacion(Reservacion reservacionIdreservacion) {
        this.reservacionIdreservacion = reservacionIdreservacion;
    }

    @XmlTransient
    public List<Facturacion> getFacturacionList() {
        return facturacionList;
    }

    public void setFacturacionList(List<Facturacion> facturacionList) {
        this.facturacionList = facturacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcotizacion != null ? idcotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idcotizacion == null && other.idcotizacion != null) || (this.idcotizacion != null && !this.idcotizacion.equals(other.idcotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.maynoralvarez.Cotizacion[ idcotizacion=" + idcotizacion + " ]";
    }
    
}
