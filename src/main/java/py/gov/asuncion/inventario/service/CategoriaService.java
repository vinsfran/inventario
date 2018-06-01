/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service;

import java.util.List;
import py.gov.asuncion.inventario.entity.Categorias;

/**
 *
 * @author vinsfran
 */
public interface CategoriaService {

    public abstract List<Categorias> listAll();
    
    public abstract Categorias findById(int id);

    public abstract Categorias add(Categorias course);

    public abstract int remove(int id);

    public abstract Categorias update(Categorias course);
}
