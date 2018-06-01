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
import py.gov.asuncion.inventario.entity.Categorias;
import py.gov.asuncion.inventario.service.CategoriaService;
import py.gov.asuncion.inventario.repository.CategoriaJpaRepository;

/**
 *
 * @author vinsfran
 */
@Service("categoriaServiceImpl")
public class CategoriaServiceImpl implements CategoriaService {

    private static final Log LOG = LogFactory.getLog(CategoriaServiceImpl.class);

    @Autowired
    @Qualifier("categoriaJpaRepository")
    private CategoriaJpaRepository categoriaJpaRepository;

    @Override
    public List<Categorias> listAll() {
        LOG.info("Call: listAllCategorias()");
        return categoriaJpaRepository.findAll();
    }

    @Override
    public Categorias add(Categorias categoria) {
        LOG.info("Call: addCategorias()");
        //Guarda el objeto recibido y luego retorna el objeto guardado
        return categoriaJpaRepository.save(categoria);
    }

    @Override
    public int remove(int id) {
        categoriaJpaRepository.deleteById(id);
        return 0;
    }

    @Override
    public Categorias update(Categorias categoria) {
        return categoriaJpaRepository.save(categoria);
    }

    @Override
    public Categorias findById(int id) {
        return categoriaJpaRepository.findByPkIdcategoria(id);
    }

}
