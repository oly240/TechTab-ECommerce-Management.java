package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;


/**
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */
@Data
@Entity
@Table(name = "DetaliiComanda")
public class DetaliiComanda {

    @EmbeddedId
    private DetaliiComandaKey id = new DetaliiComandaKey();

    @ManyToOne
    @MapsId("comandaId") // Leaga partea de cheie de obiectul Comanda
    @JoinColumn(name = "ComandaID")
    @ToString.Exclude
    private Comanda comanda;

    @ManyToOne
    @MapsId("produsId") // Leaga partea de cheie de obiectul Produs
    @JoinColumn(name = "ProdusID")
    @ToString.Exclude
    private Produs produs;

    @Column(name = "Pret", nullable = false)
    private BigDecimal pret;
}