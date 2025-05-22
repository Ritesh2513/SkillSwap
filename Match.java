package com.example.teachlearn.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "`match_id`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User requester;

    @ManyToOne
    private User responder;

    private String status; // pending, accepted, rejected

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getRequester() { return requester; }
    public void setRequester(User requester) { this.requester = requester; }
    public User getResponder() { return responder; }
    public void setResponder(User responder) { this.responder = responder; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}