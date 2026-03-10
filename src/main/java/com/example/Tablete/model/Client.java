package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;

/** Clasa pentru entitatea Client.
 * Gestioneaza datele personale ale cumparatorilor (Nume, Prenume, Email).
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClientID")
    private Integer id;

    @Column(name = "Nume", nullable = false)
    private String nume;

    @Column(name = "Prenume", nullable = false)
    private String prenume;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;
}