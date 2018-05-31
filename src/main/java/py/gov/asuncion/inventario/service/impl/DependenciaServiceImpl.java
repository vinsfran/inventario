/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import py.gov.asuncion.inventario.entity.Dependencia;
import py.gov.asuncion.inventario.repository.DependenciaJpaRepository;
import py.gov.asuncion.inventario.service.DependenciaService;

/**
 *
 * @author vinsfran
 */
@Service("dependenciaServiceImpl")
public class DependenciaServiceImpl implements DependenciaService {

    private static final Log LOG = LogFactory.getLog(DependenciaServiceImpl.class);

    @Autowired
    @Qualifier("dependenciaJpaRepository")
    private DependenciaJpaRepository dependenciaJpaRepository;

    @Override
    public List<Dependencia> listAll() {
        LOG.info("Call: listAllDependencias()");
        return dependenciaJpaRepository.findAll();
    }

    @Override
    public Dependencia add(Dependencia course) {
        LOG.info("Call: addDependencia()");
        //Guarda el objeto recibido y luego retorna el objeto guardado
        return dependenciaJpaRepository.save(course);
    }

    @Override
    public int remove(int id) {
        dependenciaJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public Dependencia update(Dependencia course) {
        return dependenciaJpaRepository.save(course);
    }

}
