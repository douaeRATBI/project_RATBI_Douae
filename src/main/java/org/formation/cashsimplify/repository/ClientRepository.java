package org.formation.cashsimplify.repository;

import org.formation.cashsimplify.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}