/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service;

import java.util.List;
import py.gov.asuncion.inventario.entity.Dependencia;

/**
 *
 * @author vinsfran
 */
public interface DependenciaService {

    public abstract List<Dependencia> listAll();

    public abstract Dependencia add(Dependencia course);

    public abstract int remove(int id);

    public abstract Dependencia update(Dependencia course);
}
