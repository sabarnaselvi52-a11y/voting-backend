package com.voting.backend.controller;

import com.voting.backend.service.VoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
@CrossOrigin
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/cast")
    public String castVote(@RequestParam String token,
                           @RequestParam String candidate,
                           @RequestParam String constituency) {
        return voteService.castVote(token, candidate, constituency);
    }
}
