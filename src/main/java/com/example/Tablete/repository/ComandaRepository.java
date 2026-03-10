package com.example.Tablete.repository;

import com.example.Tablete.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/** Interfata Repository standard pentru operatiile CRUD.
 * Extinde JpaRepository pentru a oferi functionalitati de baza fara cod suplimentar.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    // Top vanzari pe categorii (statistica pentru Admin)
    @Query(value =
            "SELECT c.NumeCategorie, SUM(dc.Pret) as TotalIncasari " +
                    "FROM DetaliiComanda dc " +
                    "JOIN Produs p ON dc.ProdusID = p.ProdusID " +
                    "JOIN Categorie c ON p.CategorieID = c.CategorieID " +
                    "GROUP BY c.NumeCategorie " +
                    "ORDER BY TotalIncasari DESC",
            nativeQuery = true)
    List<Object[]> getStatisticiVanzariPeCategorii();

    // Gaseste clientii VIP (care au comenzi peste media tuturor comenzilor)
    @Query(value =
            "SELECT * FROM Comanda " +
                    "WHERE Total > (SELECT AVG(Total) FROM Comanda)",
            nativeQuery = true)
    List<Comanda> getComenziPesteMedie();
}