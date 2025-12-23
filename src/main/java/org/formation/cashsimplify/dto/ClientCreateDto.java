package org.formation.cashsimplify.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientCreateDto(

        @NotBlank(message = "Le nom ne peut pas être vide")
        String nom,

        @NotBlank(message = "Le prénom ne peut pas être vide")
        String prenom,

        @Size(max = 255, message = "Adresse trop longue")
        String adresse,

        @Size(max = 10, message = "Code postal trop long")
        String codePostal,

        @Size(max = 50, message = "Ville trop longue")
        String ville,

        @Size(max = 20, message = "Téléphone trop long")
        String telephone

) {}
