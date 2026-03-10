package com.example.Tablete.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

/**
 * @author Dumitrascu Olivia-Maria
 * @version 12.01.2026
 */

@Data
@EqualsAndHashCode // Obligatoriu pentru chei compuse
@Embeddable
public class DetaliiComandaKey implements Serializable {

    @Column(name = "ComandaID")
    private Integer comandaId;

    @Column(name = "ProdusID")
    private Integer produsId;
}