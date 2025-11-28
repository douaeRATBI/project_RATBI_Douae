package org.formation.cashsimplify.dto;

import java.math.BigDecimal;

public record VirementRequest(
        Long sourceId,
        Long destinationId,
        BigDecimal montant
) {}
