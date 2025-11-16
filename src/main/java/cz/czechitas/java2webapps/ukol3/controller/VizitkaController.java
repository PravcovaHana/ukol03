package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import cz.czechitas.java2webapps.ukol3.service.VizitkaService;
import jakarta.validation.Valid;
import org.eclipse.jetty.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    public Object detail(@PathVariable int id) {
        Optional<Vizitka> vizitka = service.findById(id);
        if (vizitka.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", vizitka.get());
        modelAndView.addObject("idVizitka", id);
        return modelAndView;
    }

    @ExceptionHandler(ResponseStatusException.class)
    public String notFound() {
        return "not found";
    }

    @PostMapping("/{id}")
    public Object edit(@PathVariable int id, @Valid @ModelAttribute("vizitka")  Vizitka vizitka, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("vizitka", vizitka);
            modelAndView.addObject("idVizitka", id);
            return modelAndView;
        }
        service.edit(vizitka);
        return "redirect:/";
    }


    @GetMapping("/nova")
    public ModelAndView detail() {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", service.nova());
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
