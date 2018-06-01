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
 * @author fsalinas
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByPkIdproveedor", query = "SELECT p FROM Proveedor p WHERE p.pkIdproveedor = :pkIdproveedor")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByTelefNro", query = "SELECT p FROM Proveedor p WHERE p.telefNro = :telefNro")
    , @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idproveedor")
    private Integer pkIdproveedor;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telef_nro")
    private Integer telefNro;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(Integer pkIdproveedor) {
        this.pkIdproveedor = pkIdproveedor;
    }

    public Integer getPkIdproveedor() {
        return pkIdproveedor;
    }

    public void setPkIdproveedor(Integer pkIdproveedor) {
        this.pkIdproveedor = pkIdproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefNro() {
        return telefNro;
    }

    public void setTelefNro(Integer telefNro) {
        this.telefNro = telefNro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdproveedor != null ? pkIdproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.pkIdproveedor == null && other.pkIdproveedor != null) || (this.pkIdproveedor != null && !this.pkIdproveedor.equals(other.pkIdproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.gov.asuncion.inventario.entity.Proveedor[ pkIdproveedor=" + pkIdproveedor + " ]";
    }
    
}
