package org.formation.cashsimplify.dto;

import jakarta.validation.constraints.Size;

public record ClientUpdateDto(

        String nom,
        String prenom,

        @Size(max = 255)
        String adresse,

        @Size(max = 10)
        String codePostal,

        @Size(max = 50)
        String ville,

        @Size(max = 20)
        String telephone

) {}
