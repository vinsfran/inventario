/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service;

import java.util.List;
import py.gov.asuncion.inventario.entity.Almacen;
import py.gov.asuncion.inventario.entity.Almacen;

/**
 *
 * @author vinsfran
 */
public interface AlmacenService {

    public abstract List<Almacen> listAll();
    
    public abstract Almacen findById(int id);

    public abstract Almacen add(Almacen course);

    public abstract int remove(int id);

    public abstract Almacen update(Almacen course);
}
