package org.formation.cashsimplify.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class CompteCourant extends Compte {
    private BigDecimal decouvertAutorise = BigDecimal.valueOf(1000);

    @Override
    protected boolean peutDebiter(BigDecimal montant) {
        BigDecimal nouveauSolde = getSolde().subtract(montant);
        BigDecimal maxDecouvert = decouvertAutorise.negate();
        return nouveauSolde.compareTo(maxDecouvert) >= 0;
    }
}
