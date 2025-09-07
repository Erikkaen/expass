package main.java.Spring.pollapp.model;


public class Vote {
    private Long id;
    private User user;
    private VoteOption option;

    public Vote() {}
    public Vote(Long id, User user, VoteOption option) {
        this.id = id;
        this.user = user;
        this.option = option;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public VoteOption getOption() { return option; }
    public void setOption(VoteOption option) { this.option = option; }
}