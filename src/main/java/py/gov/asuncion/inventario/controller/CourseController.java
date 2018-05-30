/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import py.gov.asuncion.inventario.entity.Course;
import py.gov.asuncion.inventario.service.CourseService;

/**
 *
 * @author vinsfran
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    public static final String COURSES_VIEW = "courses";

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses() {
        LOG.info("Call: listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOG.info("Call: addCourse()" + " -- Param: " + course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
        //return "redirect:/listcourses";
        //localhost:8080/listcourses
    }

}
