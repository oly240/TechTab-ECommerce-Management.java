package com.example.Tablete.repository;

import com.example.Tablete.model.DetaliiComanda;
import com.example.Tablete.model.DetaliiComandaKey;
import org.springframework.data.jpa.repository.JpaRepository;

/** Interfata Repository pentru detaliile specifice ale comenzilor.
 * Gestioneaza liniile de comanda (produsele asociate unei comenzi si cantitatile lor).
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

public interface DetaliiComandaRepository extends JpaRepository<DetaliiComanda, DetaliiComandaKey> {
}