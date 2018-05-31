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
import py.gov.asuncion.inventario.entity.Almacen;
import py.gov.asuncion.inventario.repository.AlmacenJpaRepository;
import py.gov.asuncion.inventario.service.AlmacenService;

/**
 *
 * @author vinsfran
 */
@Service("almacenServiceImpl")
public class AlmacenServiceImpl implements AlmacenService {

    private static final Log LOG = LogFactory.getLog(AlmacenServiceImpl.class);

    @Autowired
    @Qualifier("almacenJpaRepository")
    private AlmacenJpaRepository almacenJpaRepository;

    @Override
    public List<Almacen> listAll() {
        LOG.info("Call: listAllAlmacens()");
        return almacenJpaRepository.findAll();
    }

    @Override
    public Almacen add(Almacen course) {
        LOG.info("Call: addAlmacen()");
        //Guarda el objeto recibido y luego retorna el objeto guardado
        return almacenJpaRepository.save(course);
    }

    @Override
    public int remove(int id) {
        almacenJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public Almacen update(Almacen course) {
        return almacenJpaRepository.save(course);
    }

    @Override
    public Almacen findById(int id) {
        return almacenJpaRepository.findByIdalmacen(id);
    }

}
