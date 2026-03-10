package com.example.Tablete.repository;

import com.example.Tablete.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/** Interfata Repository pentru gestionarea datelor clientilor.
 * Permite operatii CRUD (Create, Read, Update, Delete) asupra tabelului Client.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}