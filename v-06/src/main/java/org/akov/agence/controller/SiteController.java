package org.akov.agence.controller;

import org.akov.agence.model.Bien;
import org.akov.agence.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SiteController {

    @Autowired
    private BienService bienService;


    @GetMapping("/")
    public String index(ModelMap map) {
        List<Bien> list = bienService.findActiveAll();

        map.put("listBiens", list);
        return "index";
    }

    @GetMapping("/detail")
    public String detail(ModelMap map, @RequestParam Integer id) {
        map.put("bien", bienService.findById(id));
        return "detailBien";
    }
}
