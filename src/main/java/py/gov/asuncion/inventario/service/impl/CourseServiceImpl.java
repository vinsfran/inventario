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
import py.gov.asuncion.inventario.entity.Course;
import py.gov.asuncion.inventario.repository.CourseJpaRepository;
import py.gov.asuncion.inventario.service.CourseService;

/**
 *
 * @author vinsfran
 */
@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> listAll() {
        LOG.info("Call: listAllCourses()");
        return courseJpaRepository.findByOrderByIdAsc();
    }

    @Override
    public Course findById(int id) {
        return courseJpaRepository.findById(id);
    }

    @Override
    public Course add(Course course) {
        LOG.info("Call: addCourse()");
        //Guarda el objeto recibido y luego retorna el objeto guardado
        return courseJpaRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseJpaRepository.save(course);
    }

    @Override
    public int remove(int id) {
        courseJpaRepository.deleteById(id);
        return 0;
    }

}
