package cz.czechitas.java2webapps.ukol3.service;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import cz.czechitas.java2webapps.ukol3.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VizitkaService {

    private VizitkaRepository vizitkaRepository;

    @Autowired
    public VizitkaService(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    public Iterable<Vizitka> getAll() {
        return vizitkaRepository.findAll();
    }

    public Vizitka getById(int id) {
        return vizitkaRepository.getById(id);
    }

    public Vizitka append(Vizitka vizitka) {
        vizitka.setId(null);
        vizitkaRepository.save(vizitka);
        return vizitka;
    }

    public void deleteById(int id) {
        vizitkaRepository.deleteById(id);
    }

    public Vizitka edit(Vizitka vizitka) {
        vizitkaRepository.save(vizitka);
        return vizitka;
    }
}
