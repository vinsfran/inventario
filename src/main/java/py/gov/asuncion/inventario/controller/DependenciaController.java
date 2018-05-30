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
import py.gov.asuncion.inventario.entity.Dependencia;
import py.gov.asuncion.inventario.service.DependenciaService;

/**
 *
 * @author vinsfran
 */
@Controller
@RequestMapping("/dependencia")
public class DependenciaController {

    private static final Log LOG = LogFactory.getLog(DependenciaController.class);

    public static final String VIEW = "dependencia";

    @Autowired
    @Qualifier("dependenciaServiceImpl")
    private DependenciaService dependenciaService;

    @GetMapping("/list")
    public ModelAndView listAll() {
        LOG.info("Call: listAll()");
        ModelAndView mav = new ModelAndView(VIEW);
        //mav.addObject("course", new Dependencia());
        mav.addObject("dependencias", dependenciaService.listAll());
        return mav;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dependencia") Dependencia dependencia) {
        LOG.info("Call: add()" + " -- Param: " + dependencia.toString());
        dependenciaService.add(dependencia);
        return "redirect:/dependencia/list";
        //return "redirect:/listcourses";
        //localhost:8080/listcourses
    }

}
