package com.example.Tablete.service;

import com.example.Tablete.model.Comanda;
import com.example.Tablete.model.ComandaStatus;
import com.example.Tablete.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> getAllComenzi() {
        return comandaRepository.findAll();
    }

    public void saveComanda(Comanda comanda) {
        comandaRepository.save(comanda);
    }

    public void updateStatus(Integer comandaId, ComandaStatus newStatus) {
        Comanda comanda = comandaRepository.findById(comandaId).orElse(null);
        if (comanda != null) {
            comanda.setStatus(newStatus);
            comandaRepository.save(comanda);
        }
    }

    public List<Object[]> getStatisticiVanzari() {
        return comandaRepository.getStatisticiVanzariPeCategorii();
    }
}