package com.example.Tablete.model;

/** Enumerare pentru starile posibile ale unei comenzi.
 * Defineste fluxul de procesare: NEW -> PROCESSING -> SHIPPED -> COMPLETED.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

public enum ComandaStatus {
    NEW,        // Plasata
    PROCESSING, // In procesare
    SHIPPED,    // Expediata
    COMPLETED,  // Finalizata
    CANCELED    // Anulata
}