package Spring.pollapp.model;

import java.util.List;
import java.util.ArrayList;


public class VoteOption {
    private Long id;
    private String text;
    private List<Vote> votes = new ArrayList<>();

    public VoteOption() {}
    public VoteOption(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public List<Vote> getVotes() { return votes; }
    public void setVotes(List<Vote> votes) { this.votes = votes; }
}


