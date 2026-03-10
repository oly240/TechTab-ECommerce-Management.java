package com.example.Tablete.model;

import jakarta.persistence.*;
import lombok.Data;

/** Clasa pentru entitatea Specificatii (relatie 1-la-1 cu Produs).
 * Stocheaza detalii tehnice specifice (RAM, Memorie Interna) intr-un tabel separat.
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@Entity
@Table(name = "Specificatii")
public class Specificatii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecificatieID")
    private Integer id;

    @Column(name = "RAM", nullable = false)
    private String ram;

    @Column(name = "MemorieInterna", nullable = false)
    private String memorieInterna;

    // Legatura inapoi catre Produs
    @OneToOne
    @JoinColumn(name = "ProdusID") // Asta ii spune in ce coloana din DB sa bage ID-ul
    private Produs produs;

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getMemorieInterna() { return memorieInterna; }
    public void setMemorieInterna(String memorieInterna) { this.memorieInterna = memorieInterna; }
}