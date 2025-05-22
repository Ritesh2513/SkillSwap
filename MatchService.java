package com.example.teachlearn.Services;

import com.example.teachlearn.Model.Match;
import com.example.teachlearn.Model.User;
import com.example.teachlearn.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match createMatch(User requester, User responder) {
        Match match = new Match();
        match.setRequester(requester);
        match.setResponder(responder);
        match.setStatus("pending");
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    
    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id).map(match -> {
            match.setStatus(updatedMatch.getStatus());
            match.setRequester(updatedMatch.getRequester());
            match.setResponder(updatedMatch.getResponder());
            return matchRepository.save(match);
        }).orElse(null);
    }

    public boolean deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
