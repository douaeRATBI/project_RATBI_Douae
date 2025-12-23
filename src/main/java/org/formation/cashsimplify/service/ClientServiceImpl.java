package org.formation.cashsimplify.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.dto.ClientCreateDto;
import org.formation.cashsimplify.dto.ClientDto;
import org.formation.cashsimplify.dto.ClientUpdateDto;
import org.formation.cashsimplify.entity.Client;
import org.formation.cashsimplify.mapper.ClientMapper;
import org.formation.cashsimplify.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public List<ClientDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ClientDto save(ClientCreateDto dto) {
        Client entity = mapper.toEntity(dto);
        Client saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<ClientDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Transactional
    @Override
    public Optional<ClientDto> update(Long id, ClientUpdateDto dto) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntity(existing, dto);
                    // entity gérée + @Transactional → les changements seront flush en DB
                    return mapper.toDto(existing);
                });
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
