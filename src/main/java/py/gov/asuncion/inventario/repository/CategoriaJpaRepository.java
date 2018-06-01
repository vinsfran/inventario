/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.gov.asuncion.inventario.entity.Categorias;


/**
 *
 * @author vinsfran
 */
@Repository("categoriaJpaRepository")
public interface CategoriaJpaRepository extends JpaRepository<Categorias, Serializable> {

    public abstract Categorias findByPkIdcategoria(int id);
    
}
