package com.voting.backend.repository;

import com.voting.backend.entity.SirForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SirRepository extends JpaRepository<SirForm, Long> {
    Optional<SirForm> findByEpic(String epic);
}
