package org.formation.cashsimplify.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.entity.Compte;
import org.formation.cashsimplify.repository.CompteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;

    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    @Transactional
    @Override
    public void effectuerVirement(Long idSource, Long idDestination, BigDecimal montant) {

        if (montant == null || montant.signum() <= 0) {
            throw new IllegalArgumentException("Le montant du virement doit être positif");
        }

        Compte source = compteRepository.findById(idSource)
                .orElseThrow(() -> new IllegalArgumentException("Compte source introuvable"));

        Compte destination = compteRepository.findById(idDestination)
                .orElseThrow(() -> new IllegalArgumentException("Compte destination introuvable"));

        boolean debite = source.debiter(montant);
        if (!debite) {
            throw new IllegalStateException("Solde insuffisant ou découvert dépassé");
        }
        destination.crediter(montant);
        compteRepository.save(source);
        compteRepository.save(destination);
    }
}
