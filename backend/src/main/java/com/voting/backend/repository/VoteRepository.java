package com.voting.backend.repository;

import com.voting.backend.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT v.candidate, COUNT(v) FROM Vote v GROUP BY v.candidate")
    List<Object[]> countVotes();
}
