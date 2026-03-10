package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/** Clasa pentru entitatea Comanda.
 * Retine informatiile despre tranzactii, data comenzii si statusul acesteia.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@Entity
@Table(name = "Comanda")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComandaID")
    private Integer id;

    @Column(name = "Data", nullable = false)
    private LocalDateTime data;

    @Column(name = "Total", nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING) // Salvam statusul ca text in baza de date
    @Column(name = "Status", nullable = false)
    private ComandaStatus status;

    @ManyToOne
    @JoinColumn(name = "ClientID", nullable = false)
    @ToString.Exclude // Evitam bucla infinita la printare
    private Client client;

    // Relatia cu Detalii (pentru a vedea produsele din comanda)
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<DetaliiComanda> detalii;

    public ComandaStatus getStatus() {
        return status;
    }

    public void setStatus(ComandaStatus status) {
        this.status = status;
    }
}