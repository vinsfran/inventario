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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import static py.gov.asuncion.inventario.controller.CategoriaController.FORM_VIEW;
import py.gov.asuncion.inventario.entity.Categoria;
import py.gov.asuncion.inventario.service.CategoriaService;

/**
 *
 * @author vinsfran
 */
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private static final Log LOG = LogFactory.getLog(CategoriaController.class);

    public static final String DIR_VIEW = "categoria/";
    public static final String LIST_VIEW = DIR_VIEW + "list";
    public static final String FORM_VIEW = DIR_VIEW + "form";

    @Autowired
    @Qualifier("categoriaServiceImpl")
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ModelAndView listAll() {
        LOG.info("Call: listAll()");
        ModelAndView mav = new ModelAndView(LIST_VIEW);
        mav.addObject("categorias", categoriaService.listAll());
        return mav;
    }

    @GetMapping("/form")
    public String form(@RequestParam(name = "id", required = false, defaultValue = "0") int id, Model model) {
        LOG.info("Call: form()" + " -- RequestParam: " + id);
        Categoria categoria = new Categoria();
        if (id != 0) {
            categoria = categoriaService.findById(id);
        }
        model.addAttribute("categoria", categoria);
        return FORM_VIEW;
    }

    @PostMapping("/")
    public String add(@ModelAttribute("categoria") Categoria categoria) {
        LOG.info("Call: addCategoria()" + " -- Param: " + categoria.toString());
        categoriaService.add(categoria);
        return "redirect:/categoria/";
    }

}
