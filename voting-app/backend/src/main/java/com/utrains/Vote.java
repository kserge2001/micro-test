package com.utrains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vote {
    @Id
    private String name;
    private String voteChoice;

    public Vote() {}
    public Vote(String name, String voteChoice) {
        this.name = name;
        this.voteChoice = voteChoice;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVoteChoice() { return voteChoice; }
    public void setVoteChoice(String voteChoice) { this.voteChoice = voteChoice; }
}