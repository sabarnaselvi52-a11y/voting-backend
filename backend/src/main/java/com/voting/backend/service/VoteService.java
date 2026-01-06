package com.voting.backend.service;

import com.voting.backend.entity.SirForm;
import com.voting.backend.entity.Vote;
import com.voting.backend.repository.SirRepository;
import com.voting.backend.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService {

    private final SirRepository sirRepo;
    private final VoteRepository voteRepo;

    public VoteService(SirRepository sirRepo, VoteRepository voteRepo) {
        this.sirRepo = sirRepo;
        this.voteRepo = voteRepo;
    }

    public String castVote(String token, String candidate, String constituency) {

        SirForm form = sirRepo.findAll().stream()
                .filter(f -> token.equals(f.getVotingToken()))
                .findFirst()
                .orElseThrow();

        if (form.isTokenUsed()) {
            return "Token already used";
        }

        Vote vote = new Vote();
        vote.setCandidate(candidate);
        vote.setConstituency(constituency);
        vote.setVotedAt(LocalDateTime.now());

        voteRepo.save(vote);

        form.setTokenUsed(true);
        sirRepo.save(form);

        return "Vote cast successfully";
    }
}
