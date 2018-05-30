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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cbaez
 */
@Entity
@Table(name = "dependencia")
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddependencia")
    private Integer iddependencia;
    @Size(max = 50)
    @Column(name = "descrip_direccion")
    private String descripDireccion;

    public Dependencia() {
    }

    public Dependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public Integer getIddependencia() {
        return iddependencia;
    }

    public void setIddependencia(Integer iddependencia) {
        this.iddependencia = iddependencia;
    }

    public String getDescripDireccion() {
        return descripDireccion;
    }

    public void setDescripDireccion(String descripDireccion) {
        this.descripDireccion = descripDireccion;
    }

    @Override
    public String toString() {
        return "py.gov.asuncion.inventario.entity.Dependencia[ iddependencia=" + iddependencia + " ]";
    }
    
}
