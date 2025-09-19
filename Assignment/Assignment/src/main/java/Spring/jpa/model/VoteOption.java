package Spring.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class VoteOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @JsonIgnore
    @OneToMany(mappedBy = "votesOn", cascade = CascadeType.PERSIST)
    private List<Vote> votes = new ArrayList<>();

    private int presentationOrder;

    public VoteOption() {}

    public VoteOption(String caption, int presentationOrder) {
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }

    public VoteOption(Long id,  String caption) {
        this.id = id;
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Poll getPoll() {return poll;}
    public void setPoll(Poll poll) {this.poll = poll;}

    public List<Vote> getVotes() { return votes; }
    public void setVotes(List<Vote> votes) { this.votes = votes; }
}


