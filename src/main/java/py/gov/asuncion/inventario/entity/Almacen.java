/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cbaez
 */
@Entity
@Table(name = "almacen")
public class Almacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalmacen")
    private Integer idalmacen;
    @Size(max = 15)
    @Column(name = "almacen_descp")
    private String almacenDescp;

    public Almacen() {
    }

    public Almacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public Integer getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getAlmacenDescp() {
        return almacenDescp;
    }

    public void setAlmacenDescp(String almacenDescp) {
        this.almacenDescp = almacenDescp;
    }

    @Override
    public String toString() {
        return "py.gov.asuncion.inventario.entity.Almacen[ idalmacen=" + idalmacen + " ]";
    }
    
}
