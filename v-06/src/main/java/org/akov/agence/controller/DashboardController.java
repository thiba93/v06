package org.akov.agence.controller;

import org.akov.agence.model.Bien;
import org.akov.agence.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DashboardController {


    @Autowired
    private BienService bienService;


    @GetMapping("/dashboard")
    public String index(ModelMap map,@RequestParam(required = false) Integer id){
        Bien bien = new Bien();
        if (id != null) {
            bien = this.bienService.findById(id); // récupérer les infos du bien à partir de l'id
        }

        map.put("bien", bien);

        List<Bien> biens = this.bienService.findAll();
        map.put("listBiens", biens);
        return "dashboard/index";
    }

    @PostMapping("/dashboard")
    public String recupForm(@ModelAttribute Bien bien, ModelMap map) {
        // récupérer le formulaire
        if ( bien.getTitre().length() <= 3) {
            map.put("erreur","Le titre est trop court");
            return "dashboard/index";
        }

        if ( bien.getPrix() <= 0) {
            map.put("erreur","Le prix doit être positif");
            return "dashboard/index";
        }

        this.bienService.save(bien); // j'ajout le bien dans la bdd

        return "redirect:/dashboard"; // rediriger vers la page index get
    }


    @GetMapping("/dashboard/{id}/{visible}")
    public String edit(@PathVariable Integer id, @PathVariable boolean visible){
        Bien bien = this.bienService.findById(id);
        bien.setVisible(visible);
        this.bienService.save(bien);
        return "redirect:/dashboard";
    }
}
