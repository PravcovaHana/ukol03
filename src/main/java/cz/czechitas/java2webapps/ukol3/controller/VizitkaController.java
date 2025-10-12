package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.Entity.Vizitka;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

    private List<Vizitka> vizitky = List.of(
       new Vizitka("Jana", "Zcestovalá",  "České dráhy a.s.", "Riegrovo náměstí 1660/2a", "Hradec Králové", "500 02", "zcestovala@cd.cz", "+420 603502502", "www.cd.cz"),
       new Vizitka("Petra", "Černá",  "Černá IT Solutions", "8. května 13", "Opava", "746 01", "cerna@solution.cz", "+420 702154234", "www.cernavlna.cz"),
       new Vizitka("Eva", "Dvořáková",  "Digitální krajina", "Zelené údolí 1024", "Liberec", "460 01", "evadvorakova@dk.cz", "+420 678901234", "www.digitalnikrajina.cz"),
       new Vizitka("Martina", "Hlaváčová",  "Zajímavé cesty", "Nebeská 3", "Olomouc", "779 00", "hlavacova@zc.cz", "+420 739252623", "www.zajimavecesty.cz"),
       new Vizitka("Pan", "Nikdo"),
       new Vizitka("Věra", "Pomalá",  "Rychlý tým", "Gahurova 292", "Zlín", "760 01", "pomala@rychlytym.cz", "+420 602452122", "www.rychlytym.cz"));


    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("/seznam");
        modelAndView.addObject("vizitky", vizitky);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("vizitka", vizitky.get(id));
        return modelAndView;

    }
}
