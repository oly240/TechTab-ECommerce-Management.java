package com.example.Tablete.model;


import jakarta.persistence.*;
import lombok.Data;

/** Clasa pentru entitatea Categorie (relatie 1-la-Multi cu Produs).
 * Permite gruparea produselor in categorii logice (ex: Business, Gaming).
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data // Genereaza automat Getters, Setters, toString
@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategorieID")
    private Integer id;

    @Column(name = "NumeCategorie", unique = true, nullable = false)
    private String numeCategorie;
}