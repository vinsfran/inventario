/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.inventario.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import static py.gov.asuncion.inventario.controller.AlmacenController.FORM_VIEW;
import py.gov.asuncion.inventario.entity.Almacen;
import py.gov.asuncion.inventario.entity.Almacen;
import py.gov.asuncion.inventario.entity.Almacen;
import py.gov.asuncion.inventario.service.AlmacenService;

/**
 *
 * @author vinsfran
 */
@Controller
@RequestMapping("/almacen")
public class AlmacenController {

    private static final Log LOG = LogFactory.getLog(AlmacenController.class);

    public static final String DIR_VIEW = "almacen/";
    public static final String LIST_VIEW = DIR_VIEW + "list";
    public static final String FORM_VIEW = DIR_VIEW + "form";

    @Autowired
    @Qualifier("almacenServiceImpl")
    private AlmacenService almacenService;

    @GetMapping("/")
    public ModelAndView listAll() {
        LOG.info("Call: listAll()");
        ModelAndView mav = new ModelAndView(LIST_VIEW);
        mav.addObject("almacenes", almacenService.listAll());
        return mav;
    }

    @GetMapping("/form")
    public String form(@RequestParam(name = "id", required = false, defaultValue = "0") int id, Model model) {
        LOG.info("Call: form()" + " -- RequestParam: " + id);
        Almacen almacen = new Almacen();
        List<Almacen> almacenes = new ArrayList();
        if (id != 0) {
            almacen = almacenService.findById(id);
        }
        model.addAttribute("almacen", almacen);
        return FORM_VIEW;
    }

    @PostMapping("/")
    public String add(@ModelAttribute("almacen") Almacen almacen) {
        LOG.info("Call: addAlmacen()" + " -- Param: " + almacen.toString());
        almacenService.add(almacen);
        return "redirect:/almacen/";
    }

}
