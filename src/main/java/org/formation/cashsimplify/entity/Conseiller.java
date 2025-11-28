package org.formation.cashsimplify.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Conseiller {

    @Id
    @GeneratedValue
    private Long id;

    private String prenom;

    private String nom;

    @OneToMany(mappedBy = "conseiller")
    private List<Client> clients = new ArrayList<>();

    public boolean peutAccepterNouveauClient() {
        return clients.size() < 10;
    }

    public void ajouterClient(Client client) {
        if (!peutAccepterNouveauClient()) {
            throw new IllegalStateException("Ce conseiller a déjà 10 clients.");
        }
        clients.add(client);
        client.setConseiller(this);
    }

    public void retirerClient(Client client) {
        clients.remove(client);
        if (client.getConseiller() == this) {
            client.setConseiller(null);
        }
    }
}
