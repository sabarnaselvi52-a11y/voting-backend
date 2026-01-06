package com.voting.backend.controller;

import com.voting.backend.entity.SirForm;
import com.voting.backend.service.CitizenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
@CrossOrigin
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping("/sir/submit")
    public SirForm submit(@RequestBody SirForm form) {
        return citizenService.submitSir(form);
    }

    @GetMapping("/status/{epic}")
    public SirForm status(@PathVariable String epic) {
        return citizenService.getStatus(epic);
    }
}
