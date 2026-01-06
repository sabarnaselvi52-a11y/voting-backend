package com.voting.backend.service;

import com.voting.backend.entity.SirForm;
import com.voting.backend.repository.SirRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VaoService {

    private final SirRepository sirRepo;

    public VaoService(SirRepository sirRepo) {
        this.sirRepo = sirRepo;
    }

    // Get all pending SIR forms
    public List<SirForm> pending() {
        return sirRepo.findAll()
                .stream()
                .filter(f -> "PENDING".equals(f.getStatus()))
                .toList();
    }

    // Approve SIR and generate token
    public SirForm approve(Long id) {
        SirForm f = sirRepo.findById(id).orElseThrow();
        f.setStatus("APPROVED");
        f.setVotingToken(UUID.randomUUID().toString()); // ✅ CORRECT
        f.setTokenUsed(false);
        return sirRepo.save(f);
    }

    // Reject SIR
    public SirForm reject(Long id) {
        SirForm f = sirRepo.findById(id).orElseThrow();
        f.setStatus("REJECTED");
        return sirRepo.save(f);
    }
}
