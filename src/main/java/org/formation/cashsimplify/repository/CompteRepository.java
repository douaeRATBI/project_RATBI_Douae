package org.formation.cashsimplify.repository;

import org.formation.cashsimplify.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}