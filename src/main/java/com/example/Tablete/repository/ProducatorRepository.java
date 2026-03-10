package com.example.Tablete.repository;

import com.example.Tablete.model.Producator;
import org.springframework.data.jpa.repository.JpaRepository;

/** Interfata Repository standard pentru operatiile CRUD.
 * Extinde JpaRepository pentru a oferi functionalitati de baza fara cod suplimentar.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

public interface ProducatorRepository extends JpaRepository<Producator, Integer> {
}