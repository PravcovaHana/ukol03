package cz.czechitas.java2webapps.ukol3.service;

import cz.czechitas.java2webapps.ukol3.controller.Vizitka;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VizitkaService {
    private final List<Vizitka> seznamVizitek = new ArrayList<>();

    public VizitkaService() {
        seznamVizitek.add(
                new Vizitka("Jana",
                        "Zcestovalá",
                        "České dráhy a.s.",
                        "Riegrovo náměstí 1660/2a",
                        "Hradec Králové", "500 02",
                        "zcestovala@cd.cz",
                        "+420 603502502",
                        "www.cd.cz")
        );

        seznamVizitek.add(
                new Vizitka("Eva",
                        "Dvořáková",
                        "Digitální krajina",
                        "Zelené údolí 1024",
                        "Liberec", "460 01",
                        "evadvorakova@dk.cz",
                        "+420 678901234",
                        "www.digitalnikrajina.cz")
        );

        seznamVizitek.add(
                new Vizitka("Martina",
                        "Hlaváčová",
                        "Zajímavé cesty",
                        "Nebeská 3",
                        "Olomouc",
                        "779 00",
                        "hlavacova@zc.cz",
                        "+420 739252623",
                        "www.zajimavecesty.cz")

                );

        seznamVizitek.add(
                new Vizitka("Pan", "Nikdo")
        );

        seznamVizitek.add(
                new Vizitka("Věra",
                        "Pomalá",
                        "Rychlý tým",
                        "Gahurova 292",
                        "Zlín", "760 01",
                        "pomala@rychlytym.cz",
                        "+420 602452122",
                        "www.rychlytym.cz")
        );
    }

    public List<Vizitka> getAll() {
        return seznamVizitek;
    }

    public Vizitka getById(int id) {
        return seznamVizitek.get(id);
    }

    public void append(Vizitka vizitka) {
        seznamVizitek.add(vizitka);
    }

    public void deleteById(int id) {
        seznamVizitek.remove(id);
    }

    public void edit(int id, Vizitka vizitka) {
        seznamVizitek.set(id, vizitka);
    }
}
