package org.formation.cashsimplify.service;

import org.formation.cashsimplify.entity.Conseiller;

import java.util.List;
import java.util.Optional;

public interface ConseillerService {

    List<Conseiller> findAll();

    Optional<Conseiller> findById(Long id);

    Conseiller save(Conseiller conseiller);

    void assignClient(Long conseillerId, Long clientId);
}
