package Spring.jpa.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Poll {


    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Poll poll;

    @ManyToOne
    @JoinColumn
    private User createdBy;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<VoteOption> options = new ArrayList<>();

    public Poll() {}

    public Poll(User createdBy, String caption) {
        this.caption = caption;
        this.createdBy = createdBy;
    }

    public Poll(Long id, String caption, User createdBy) {
        this.id = id;
        this.caption = caption;
        this.createdBy = createdBy;
    }

    /**
     *
     * Adds a new option to this Poll and returns the respective
     * VoteOption object with the given caption.
     * The value of the presentationOrder field gets determined
     * by the size of the currently existing VoteOptions for this Poll.
     * I.e. the first added VoteOption has presentationOrder=0, the secondly
     * registered VoteOption has presentationOrder=1 ans so on.
     */
    public VoteOption addVoteOption(String caption) {
        int order = options.size();
        VoteOption voteOption = new VoteOption(caption, order);
        voteOption.setPoll(this);
        options.add(voteOption);
        return voteOption;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Long getId() { return id; }
    //public void setId(Long id) { this.id = id; }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public List<VoteOption> getOptions() { return options; }
    public void setOptions(List<VoteOption> options) { this.options = options; }
}