package com.example.Tablete.service;

import com.example.Tablete.model.Produs;
import com.example.Tablete.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/** Clasa Service care contine logica de business a aplicatiei.
 * Intermediaza operatiile dintre Controller si Repository (ex: salvarea in cascada).
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> getAllProduse() {
        return produsRepository.findAll();
    }

    public Produs getProdusById(Integer id) {
        return produsRepository.findById(id).orElse(null);
    }

    // Metoda pentru salvare (Adaugare/Editare)
    public void saveProdus(Produs produs) {
        if (produs.getSpecificatii() != null) {
            produs.getSpecificatii().setProdus(produs);
        }

        produsRepository.save(produs);
    }

    public void deleteProdus(Integer id) {
        produsRepository.deleteById(id);
    }

    public List<Produs> cautaProduse(String keyword) {
        if (keyword != null) {
            return produsRepository.cautaProdus(keyword);
        }
        return produsRepository.findAll();
    }
}