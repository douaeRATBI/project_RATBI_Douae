package org.formation.cashsimplify.controller;

import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.entity.Conseiller;
import org.formation.cashsimplify.service.ConseillerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conseillers")
@RequiredArgsConstructor
public class ConseillerController {

    private final ConseillerService conseillerService;

    @GetMapping
    public List<Conseiller> getAll() {
        return conseillerService.findAll();
    }

    @PostMapping
    public Conseiller create(@RequestBody Conseiller conseiller) {
        return conseillerService.save(conseiller);
    }

    @PostMapping("/{conseillerId}/clients/{clientId}")
    public ResponseEntity<String> assignClient(
            @PathVariable Long conseillerId,
            @PathVariable Long clientId
    ) {
        conseillerService.assignClient(conseillerId, clientId);
        return ResponseEntity.ok("Client assigné au conseiller");
    }
}
