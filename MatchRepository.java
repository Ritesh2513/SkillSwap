package com.example.teachlearn.Repository;

import com.example.teachlearn.Model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}