package main.java.Spring.pollapp.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {
    private Long id;
    private String question;
    private User owner;
    private List<VoteOption> options = new ArrayList<>();

    public Poll() {}
    public Poll(Long id, String question, User owner) {
        this.id = id;
        this.question = question;
        this.owner = owner;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public List<VoteOption> getOptions() { return options; }
    public void setOptions(List<VoteOption> options) { this.options = options; }
}