/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service;

import java.util.List;
import py.gov.asuncion.inventario.entity.Categoria;

/**
 *
 * @author vinsfran
 */
public interface CategoriaService {

    public abstract List<Categoria> listAll();
    
    public abstract Categoria findById(int id);

    public abstract Categoria add(Categoria categoria);

    public abstract int remove(int id);

    public abstract Categoria update(Categoria categoria);
}
