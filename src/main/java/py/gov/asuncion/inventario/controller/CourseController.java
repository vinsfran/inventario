/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import py.gov.asuncion.inventario.entity.Course;
import py.gov.asuncion.inventario.service.CourseService;

/**
 *
 * @author vinsfran
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private static final Log LOG = LogFactory.getLog(CourseController.class);

    public static final String DIR_COURSE = "course/";
    public static final String LIST_VIEW = DIR_COURSE + "list";
    public static final String FORM_VIEW = DIR_COURSE + "form";

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/")
    public ModelAndView listAllCourses() {
        LOG.info("Call: listAllCourses()");
        ModelAndView mav = new ModelAndView(LIST_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAll());
        return mav;
    }

    @GetMapping("/form")
    public String form(@RequestParam(name = "id", required = false, defaultValue = "0") int id, Model model) {
        LOG.info("Call: form()" + " -- RequestParam: " + id);
        Course course = new Course();
        if (id != 0) {
            course = courseService.findById(id);
        }
        model.addAttribute("course", course);
        return FORM_VIEW;
    }

    @PostMapping("/")
    public String addCourse(@ModelAttribute("course") Course course) {
        LOG.info("Call: addCourse()" + " -- Param: " + course.toString());
        courseService.add(course);
        return "redirect:/course/";
    }

}
