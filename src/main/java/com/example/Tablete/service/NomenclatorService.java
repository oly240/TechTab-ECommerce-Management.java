package com.example.Tablete.service;

import com.example.Tablete.model.Categorie;
import com.example.Tablete.model.Producator;
import com.example.Tablete.repository.CategorieRepository;
import com.example.Tablete.repository.ProducatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NomenclatorService {
    @Autowired private CategorieRepository categorieRepository;
    @Autowired private ProducatorRepository producatorRepository;

    public List<Categorie> getAllCategorii() { return categorieRepository.findAll(); }
    public List<Producator> getAllProducatori() { return producatorRepository.findAll(); }
}