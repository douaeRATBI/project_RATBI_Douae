package org.formation.cashsimplify.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue
    private Long id;
    private String numeroCompte;
    private BigDecimal solde = BigDecimal.ZERO;
    private LocalDate dateOuverture = LocalDate.now();
    @ManyToOne
    private Client client;
    public void crediter(BigDecimal montant) {
        if (montant == null || montant.signum() <= 0) {
            return;
        }
        solde = solde.add(montant);
    }
    public boolean debiter(BigDecimal montant) {
        if (montant == null || montant.signum() <= 0) {
            return false;
        }
        if (!peutDebiter(montant)) {
            return false;
        }
        solde = solde.subtract(montant);
        return true;
    }
    protected abstract boolean peutDebiter(BigDecimal montant);
}
