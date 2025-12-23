package org.formation.cashsimplify.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CompteDto(
        Long id,
        String numeroCompte,
        BigDecimal solde,
        LocalDate dateOuverture,
        String type
        ) {}
