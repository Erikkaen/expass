package Spring.jpa.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.PERSIST)
    private Set<Poll> created;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    public User() {}
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.created = new LinkedHashSet<>();
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.created = new LinkedHashSet<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return username; }
    public String getEmail() {return email; }
    public void setName(String name) { this.username = username; }

    /**
     * Creates a new Poll object for this user
     * with the given poll question
     * and returns it.
     */

    public Poll createPoll(String question) {
        return new Poll(this, question);
    }

    /**
     * Creates a new Vote for a given VoteOption in a Poll
     * and returns the Vote as an object.
     */
    public Vote voteFor(VoteOption option) {
        Vote vote = new Vote(this, option);
        option.getVotes().add(vote);
        return vote;
    }

}