package com.example.Tablete.controller;

import com.example.Tablete.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    // Pagina principala - Lista de tablete
    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        // Daca avem un cuvant cheie, cautam
        if (keyword != null) {
            model.addAttribute("listProduse", produsService.cautaProduse(keyword));
            model.addAttribute("keyword", keyword);
        } else {
            // Altfel afisam tot
            model.addAttribute("listProduse", produsService.getAllProduse());
        }
        return "index";
    }
}