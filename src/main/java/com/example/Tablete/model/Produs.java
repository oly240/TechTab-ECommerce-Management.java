package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/** Clasa pentru entitatea Produs (reprezinta tabelul principal din baza de date).
 * Gestioneaza detaliile de baza ale tabletelor, inclusiv pretul si stocul.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@Entity
@Table(name = "Produs")
public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProdusID")
    private Integer id;

    @Column(name = "Nume", nullable = false)
    private String nume;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Pret", nullable = false)
    private BigDecimal pret;

    @Column(name = "Stoc", nullable = false)
    private Integer stoc;

    @ManyToOne
    @JoinColumn(name = "CategorieID", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "ProducatorID", nullable = false)
    private Producator producator;

    @OneToOne(mappedBy = "produs", cascade = CascadeType.ALL)
    private Specificatii specificatii;

    public Specificatii getSpecificatii() {
        return specificatii;
    }

    public void setSpecificatii(Specificatii specificatii) {
        this.specificatii = specificatii;
    }
}