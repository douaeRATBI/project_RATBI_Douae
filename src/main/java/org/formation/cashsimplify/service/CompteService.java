package org.formation.cashsimplify.service;

import org.formation.cashsimplify.entity.Compte;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CompteService {
    List<Compte> findAll();
    Optional<Compte> findById(Long id);
    Compte save(Compte compte);
    void effectuerVirement(Long idSource, Long idDestination, BigDecimal montant);}
