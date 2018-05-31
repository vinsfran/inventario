/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.service;

import java.util.List;
import py.gov.asuncion.inventario.entity.Course;

/**
 *
 * @author vinsfran
 */
public interface CourseService {

    public abstract List<Course> listAll();

    public abstract Course findById(int id);

    public abstract Course add(Course course);

    public abstract Course update(Course course);

    public abstract int remove(int id);

}
