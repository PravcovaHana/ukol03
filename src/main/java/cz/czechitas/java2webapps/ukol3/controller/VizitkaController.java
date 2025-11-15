package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import cz.czechitas.java2webapps.ukol3.service.VizitkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

    private final VizitkaService service;

    @Autowired
    public VizitkaController(VizitkaService service) {this.service = service;}

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("/seznam");
        modelAndView.addObject("vizitky", service.getAll());
        return modelAndView;
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", service.getById(id));
        modelAndView.addObject("idVizitka", id);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public String edit(@PathVariable int id, Vizitka vizitka ) {
        service.edit(vizitka);
        return "redirect:/";
    }


    @GetMapping("/nova")
    public ModelAndView detail() {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", new Vizitka());
        return modelAndView;
    }

    @PostMapping("/novaUlozit")
    public String append(Vizitka vizitka) {
        service.append(vizitka);
        return "redirect:/";
    }


    @PostMapping("/delete")
    public String delete(int id) {
        service.deleteById(id);
        return "redirect:/";
    }

}
