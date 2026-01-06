package com.voting.backend.controller;

import com.voting.backend.entity.SirForm;
import com.voting.backend.repository.SirRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vao")
public class VaoController {

    private final SirRepository sirRepo;

    public VaoController(SirRepository sirRepo) {
        this.sirRepo = sirRepo;
    }

    @GetMapping("/pending")
    public List<SirForm> pending() {
        return sirRepo.findAll().stream()
                .filter(f -> "PENDING".equals(f.getStatus()))
                .toList();
    }

    @PostMapping("/approve/{id}")
    public SirForm approve(@PathVariable Long id) {
        SirForm form = sirRepo.findById(id).orElseThrow();
        form.setStatus("APPROVED");
        form.setVotingToken(UUID.randomUUID().toString());
        return sirRepo.save(form);
    }

    @PostMapping("/reject/{id}")
    public SirForm reject(@PathVariable Long id) {
        SirForm form = sirRepo.findById(id).orElseThrow();
        form.setStatus("REJECTED");
        return sirRepo.save(form);
    }
}
