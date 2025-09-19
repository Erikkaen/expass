package Spring.jpa.model;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Component
public class PollManager {
    private final Map<Long, User> users = new HashMap<>();
    private final Map<Long, Poll> polls = new HashMap<>();
    private final Map<Long, VoteOption> options = new HashMap<>();
    private final Map<Long, Vote> votes = new HashMap<>();

    private Long nextUserId = 1L;
    private Long nextPollId = 1L;
    private Long nextOptionId = 1L;
    private Long nextVoteId = 1L;

    @PostMapping
    public User createUser(String name, String email) {
        User u = new User(nextUserId++, name, email);
        users.put(u.getId(), u);
        return u;
    }
    public Collection<User> getUsers() { return users.values(); }


    public Poll createPoll(String question, User owner) {
        Poll p = new Poll(nextPollId++, question, owner);
        polls.put(p.getId(), p);
        return p;
    }


    public Collection<Poll> getPolls() { return polls.values(); }


    public VoteOption createOption(Poll poll, String text) {
        VoteOption opt = new VoteOption(nextOptionId++, text);
        poll.getOptions().add(opt);
        options.put(opt.getId(), opt);
        return opt;
    }


    public Vote castVote(User user, VoteOption votesOn) {
        votes.values().removeIf(v -> v.getUser().getId().equals(user.getId()));
        Vote v = new Vote(nextVoteId++, user, votesOn);
        votes.put(v.getId(), v);
        votesOn.getVotes().add(v);
        return v;
    }

    public Collection<Vote> getVotes() { return votes.values(); }


    public void deletePoll(Long pollId) {
        polls.remove(pollId);
        votes.values().removeIf(v -> v.getVotesOn() != null &&
                v.getVotesOn().getId().equals(pollId));
    }
}