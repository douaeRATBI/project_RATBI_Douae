package org.formation.cashsimplify.controller;

import lombok.RequiredArgsConstructor;
import org.formation.cashsimplify.dto.VirementRequest;
import org.formation.cashsimplify.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virements")
@RequiredArgsConstructor
public class VirementController {

    private final CompteService compteService;

    @PostMapping
    public ResponseEntity<String> effectuerVirement(@RequestBody VirementRequest dto) {
        System.out.println(">>> Reçu virement: " + dto);
        compteService.effectuerVirement(dto.sourceId(), dto.destinationId(), dto.montant());
        return ResponseEntity.ok("Virement effectué avec succès");
    }
}
