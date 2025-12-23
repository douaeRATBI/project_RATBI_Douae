package org.formation.cashsimplify.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.dto.ClientCreateDto;
import org.formation.cashsimplify.dto.ClientDto;
import org.formation.cashsimplify.dto.ClientUpdateDto;
import org.formation.cashsimplify.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // GET
    @GetMapping
    List<ClientDto> getClients() {
        return clientService.findAll();
    }

    // POST
    @PostMapping
    ClientDto save(@RequestBody @Valid ClientCreateDto dto) {
        return clientService.save(dto);
    }

    // GET
    @GetMapping("{id}")
    ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PATCH
    @PatchMapping("{id}")
    ResponseEntity<ClientDto> updateClient(@PathVariable Long id,
                                           @RequestBody @Valid ClientUpdateDto dto) {
        return clientService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
