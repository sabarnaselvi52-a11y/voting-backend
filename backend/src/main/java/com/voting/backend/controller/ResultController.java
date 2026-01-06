package com.voting.backend.controller;

import com.voting.backend.repository.VoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin
public class ResultController {

    private final VoteRepository voteRepo;

    public ResultController(VoteRepository voteRepo) {
        this.voteRepo = voteRepo;
    }

    @GetMapping
    public List<Object[]> results() {
        return voteRepo.countVotes();
    }
}
