package com.example.Tablete.controller;

import com.example.Tablete.model.Produs;
import com.example.Tablete.model.Specificatii;
import com.example.Tablete.model.Comanda;
import com.example.Tablete.model.ComandaStatus;
import com.example.Tablete.repository.*;
import com.example.Tablete.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Clasa Controller (MVC) care gestioneaza interactiunea cu utilizatorul.
 * Se ocupa de rutele pentru Dashboard, formulare de adaugare/editare si rapoarte.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProdusService produsService;

    @Autowired
    private ProdusRepository produsRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private ProducatorRepository producatorRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    // Pagina Principala Admin
    @GetMapping
    public String viewAdminDashboard(Model model) {
        List<Comanda> comenzi = comandaRepository.findAll();

        List<Object[]> statistici = produsRepository.getStatisticiStocPeCategorii();

        List<Produs> produse = produsRepository.findAll();

        model.addAttribute("comenzi", comenzi);
        model.addAttribute("statistici", statistici);
        model.addAttribute("produse", produse);

        return "admin_dashboard";
    }

    // Pagina Rapoarte Complexe
    @GetMapping("/rapoarte")
    public String viewRapoarte(Model model) {
        List<Produs> produseScumpe = produsRepository.findProdusePesteMedie();
        List<Produs> produseStocMare = produsRepository.findProduseCuStocMasiv();
        List<Produs> produseIncomplete = produsRepository.findProduseFaraSpecificatii();

        model.addAttribute("produseScumpe", produseScumpe);
        model.addAttribute("produseStocMare", produseStocMare);
        model.addAttribute("produseIncomplete", produseIncomplete);

        return "rapoarte";
    }

    // Formular Adaugare Produs Nou
    @GetMapping("/produs/new")
    public String showNewProductForm(Model model) {
        Produs produs = new Produs();
        produs.setSpecificatii(new Specificatii()); // Init specificatii goale

        model.addAttribute("produs", produs);
        model.addAttribute("categorii", categorieRepository.findAll());
        model.addAttribute("producatori", producatorRepository.findAll());

        return "produs_form";
    }

    // Salvare Produs
    @PostMapping("/produs/save")
    public String saveProduct(@ModelAttribute("produs") Produs produs) {
        produsService.saveProdus(produs);
        return "redirect:/admin";
    }

    // Stergere Produs
    @GetMapping("/produs/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") Integer id) {
        produsService.deleteProdus(id);
        return "redirect:/admin";
    }

    // Formular Editare Produs
    @GetMapping("/produs/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Produs produs = produsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produs invalid ID:" + id));

        model.addAttribute("produs", produs);
        model.addAttribute("categorii", categorieRepository.findAll());
        model.addAttribute("producatori", producatorRepository.findAll());

        return "produs_form"; // Refolosim acelasi formular ca la adaugare
    }

    // Schimbare Status Comanda
    @GetMapping("/comanda/status/{id}")
    public String updateStatus(@PathVariable Integer id, @RequestParam String status) {
        Comanda comanda = comandaRepository.findById(id).orElse(null);
        if (comanda != null) {
            try {
                comanda.setStatus(ComandaStatus.valueOf(status));
                comandaRepository.save(comanda);
            } catch (IllegalArgumentException e) {
                // Status invalid, ignoram
            }
        }
        return "redirect:/admin";
    }
}