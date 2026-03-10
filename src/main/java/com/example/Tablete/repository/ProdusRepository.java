package com.example.Tablete.repository;

import com.example.Tablete.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/** Interfata Repository pentru accesul la date (Data Access Layer).
 * Contine interogari SQL Native complexe, Join-uri si subcereri pentru rapoarte.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {


    // Produse dupa nume categorie
    @Query(value = "SELECT p.* FROM Produs p " +
            "JOIN Categorie c ON p.CategorieID = c.CategorieID " +
            "WHERE c.NumeCategorie = ?1", nativeQuery = true)
    List<Produs> findByNumeCategorie(String numeCategorie);

    // Cauta produse filtrand dupa Categorie SI Producator simultan
    @Query(value = "SELECT p.* FROM Produs p " +
            "JOIN Categorie c ON p.CategorieID = c.CategorieID " +
            "JOIN Producator pr ON p.ProducatorID = pr.ProducatorID " +
            "WHERE c.NumeCategorie = ?1 AND pr.Nume = ?2", nativeQuery = true)
    List<Produs> findByCategorieAndProducator(String categorie, String producator);

    // Produse cu o anumita specificatie (RAM)
    @Query(value = "SELECT p.* FROM Produs p " +
            "JOIN Specificatii s ON p.ProdusID = s.ProdusID " +
            "WHERE s.RAM LIKE %?1%", nativeQuery = true)
    List<Produs> findProduseCuRAM(String ram);

    // Join multiplu + filtrare: Categorie si Pret
    @Query(value = "SELECT p.* FROM Produs p " +
            "JOIN Categorie c ON p.CategorieID = c.CategorieID " +
            "WHERE c.NumeCategorie = ?1 AND p.Pret < ?2", nativeQuery = true)
    List<Produs> findByCategorieAndPretMic(String categorie, Double pretMaxim);

    // Afiseaza toate produsele si specificatiile lor (chiar daca nu au specificatii setate - apar cu NULL)
    @Query(value = "SELECT p.Nume, p.Pret, s.RAM, s.MemorieInterna FROM Produs p " +
            "LEFT JOIN Specificatii s ON p.ProdusID = s.ProdusID", nativeQuery = true)
    List<Object[]> getProduseWithOrWithoutSpecs();


    // Join + Agregare: Statistici stoc
    @Query(value = "SELECT c.NumeCategorie, SUM(p.Pret * p.Stoc) as ValoareTotala " +
            "FROM Produs p " +
            "JOIN Categorie c ON p.CategorieID = c.CategorieID " +
            "GROUP BY c.NumeCategorie", nativeQuery = true)
    List<Object[]> getStatisticiStocPeCategorii();



    // Subcerere in WHERE: Produse mai scumpe decat media
    @Query(value = "SELECT * FROM Produs " +
            "WHERE Pret > (SELECT AVG(Pret) FROM Produs)", nativeQuery = true)
    List<Produs> findProdusePesteMedie();

    // Subcerere complexa: Stoc mai mare decat maximul Apple
    @Query(value = "SELECT * FROM Produs WHERE Stoc > " +
            "(SELECT MAX(p2.Stoc) FROM Produs p2 " +
            " JOIN Producator pr ON p2.ProducatorID = pr.ProducatorID " +
            " WHERE pr.Nume = 'Apple')", nativeQuery = true)
    List<Produs> findProduseCuStocMasiv();

    // Subcerere cu IN: Produse 'Business'
    @Query(value = "SELECT * FROM Produs WHERE CategorieID IN " +
            "(SELECT CategorieID FROM Categorie WHERE NumeCategorie LIKE '%Business%')", nativeQuery = true)
    List<Produs> findProduseDinCategoriiBusiness();

    // Subcerere cu NOT IN: Produse fara specificatii (orphans)
    @Query(value = "SELECT * FROM Produs WHERE ProdusID NOT IN " +
            "(SELECT ProdusID FROM Specificatii)", nativeQuery = true)
    List<Produs> findProduseFaraSpecificatii();

    @Query(value = "SELECT * FROM Produs WHERE Nume LIKE %?1% OR Marca LIKE %?1%", nativeQuery = true)
    List<Produs> cautaProdus(String keyword);
}