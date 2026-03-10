package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;

/** Clasa pentru entitatea Producator (relatie 1-la-Multi cu Produs).
 * Gestioneaza informatiile despre fabricantii tabletelor (ex: Apple, Samsung).
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@Entity
@Table(name = "Producator")
public class Producator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProducatorID")
    private Integer id;

    @Column(name = "Nume", unique = true, nullable = false)
    private String nume;

    @Column(name = "Adresa")
    private String adresa;
}
