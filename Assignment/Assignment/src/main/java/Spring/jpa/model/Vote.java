package Spring.jpa.model;

import jakarta.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private VoteOption votesOn;

    public Vote() {}

    public Vote(User user, VoteOption votesOn) {
        this.user = user;
        this.votesOn = votesOn;
    }

    public Vote(Long id, User user, VoteOption votesOn) {
        this.id = id;
        this.user = user;
        this.votesOn = votesOn;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public VoteOption getVotesOn() { return votesOn; }
    public void setVotesOn(VoteOption option) { this.votesOn = option; }
}