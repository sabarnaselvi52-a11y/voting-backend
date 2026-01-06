package com.voting.backend.service;

import com.voting.backend.entity.SirForm;
import com.voting.backend.repository.SirRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CitizenService {

    private final SirRepository sirRepository;

    public CitizenService(SirRepository sirRepository) {
        this.sirRepository = sirRepository;
    }

    // SUBMIT SIR FORM
    public SirForm submitSir(SirForm form) {
        form.setStatus("PENDING");
        form.setSubmittedAt(LocalDateTime.now());
        form.setTokenUsed(false);
        return sirRepository.save(form);
    }

    // GET STATUS BY EPIC
    public SirForm getStatus(String epic) {
        return sirRepository.findByEpic(epic)
                .orElseThrow(() -> new RuntimeException("SIR form not found"));
    }

    // APPROVE (used by VAO later)
    public SirForm approve(String epic) {
        SirForm form = getStatus(epic);
        form.setStatus("APPROVED");
        form.setVotingToken(UUID.randomUUID().toString());
        return sirRepository.save(form);
    }
}
