package org.formation.cashsimplify.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class CompteEpargne extends Compte {
    private BigDecimal tauxRemuneration = BigDecimal.valueOf(0.03);

    public BigDecimal calculerInteretsAnnuels() {
        return getSolde().multiply(tauxRemuneration);
    }
    @Override
    protected boolean peutDebiter(BigDecimal montant) {
        return getSolde().compareTo(montant) >= 0;
    }
}
