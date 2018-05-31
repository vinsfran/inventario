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
 * @author cjara
 */
@Entity
@Table(name = "categorias")
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idcategoria")
    private Integer pkIdcategoria;
    @Size(max = 20)
    @Column(name = "descripcion")
    private String descripcion;

    public Categorias() {
    }

    public Categorias(Integer pkIdcategoria) {
        this.pkIdcategoria = pkIdcategoria;
    }

    public Integer getPkIdcategoria() {
        return pkIdcategoria;
    }

    public void setPkIdcategoria(Integer pkIdcategoria) {
        this.pkIdcategoria = pkIdcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "py.gov.asuncion.inventario.entity.Categorias[ pkIdcategoria=" + pkIdcategoria + " ]";
    }

}
