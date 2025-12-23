package org.formation.cashsimplify.service;

import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.entity.Client;
import org.formation.cashsimplify.entity.Conseiller;
import org.formation.cashsimplify.repository.ClientRepository;
import org.formation.cashsimplify.repository.ConseillerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConseillerServiceImpl implements ConseillerService {

    private final ConseillerRepository conseillerRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<Conseiller> findAll() {
        return conseillerRepository.findAll();
    }

    @Override
    public Optional<Conseiller> findById(Long id) {
        return conseillerRepository.findById(id);
    }

    @Override
    public Conseiller save(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
    }

    @Override
    public void assignClient(Long conseillerId, Long clientId) {
        Conseiller conseiller = conseillerRepository.findById(conseillerId)
                .orElseThrow(() -> new IllegalArgumentException("Conseiller introuvable"));

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable"));

        conseiller.ajouterClient(client);
        conseillerRepository.save(conseiller);
    }
}
