package org.akov.agence.service;

import org.akov.agence.model.Bien;
import org.akov.agence.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;


    public Bien save(Bien bien) {
        return bienRepository.save(bien);
    }

    public List<Bien> findAll() {
        return bienRepository.findAll();
    }
    public List<Bien> findActiveAll() {
        return bienRepository.findByVisibleTrue();
    }

    public Bien findById(Integer id) {
        return bienRepository.findById(id).get();
    }

}
