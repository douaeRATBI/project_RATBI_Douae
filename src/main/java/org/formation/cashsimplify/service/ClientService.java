package org.formation.cashsimplify.service;

import org.formation.cashsimplify.dto.ClientCreateDto;
import org.formation.cashsimplify.dto.ClientDto;
import org.formation.cashsimplify.dto.ClientUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientDto> findAll();

    ClientDto save(ClientCreateDto dto);

    Optional<ClientDto> findById(Long id);

    Optional<ClientDto> update(Long id, ClientUpdateDto dto);

    void delete(Long id);
}
