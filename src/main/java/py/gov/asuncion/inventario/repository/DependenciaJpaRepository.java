/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.gov.asuncion.inventario.entity.Dependencia;

/**
 *
 * @author vinsfran
 */
@Repository("dependenciaJpaRepository")
public interface DependenciaJpaRepository extends JpaRepository<Dependencia, Serializable> {

    
}
