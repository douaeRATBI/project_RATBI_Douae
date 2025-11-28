package org.formation.cashsimplify.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import org.formation.cashsimplify.entity.Compte;


@Data   // Lombok: génère getters/setters/toString/hashCode
@Entity // JPA: table en base
@NoArgsConstructor // constructeur vide obligatoire pour JPA
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide")
    private String nom;

    @NotBlank(message = "Le prénom ne peut pas être vide")
    private String prenom;

    @Size(max = 255, message = "Adresse trop longue")
    private String adresse;

    @Size(max = 10, message = "Code postal trop long")
    private String codePostal;

    @Size(max = 50, message = "Ville trop longue")
    private String ville;

    @Size(max = 20, message = "Téléphone trop long")
    private String telephone;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes = new ArrayList<>();
    @ManyToOne
    private Conseiller conseiller;

    // Constructeur to creat a client easily
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
