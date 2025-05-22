package com.example.teachlearn.Controller;

import com.example.teachlearn.Model.Match;
import com.example.teachlearn.Model.User;
import com.example.teachlearn.Services.MatchService;
import com.example.teachlearn.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @Autowired
    private UserService userService;

    @PostMapping("/request")
    public ResponseEntity<Match> requestMatch(@RequestParam Long requesterId, @RequestParam Long responderId) {
        User requester = userService.findById(requesterId);
        User responder = userService.findById(responderId);
        if (requester == null || responder == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(matchService.createMatch(requester, responder));
    }

    @GetMapping
    public ResponseEntity<?> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = matchService.getMatchById(id);
        return match != null ? ResponseEntity.ok(match) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match match = matchService.updateMatch(id, updatedMatch);
        return match != null ? ResponseEntity.ok(match) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        boolean deleted = matchService.deleteMatch(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
