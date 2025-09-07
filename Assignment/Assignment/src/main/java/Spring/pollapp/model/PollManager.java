package main.java.Spring.pollapp.model;

import main.java.Spring.pollapp.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PollManager {
    private Map<Long, User> users = new HashMap<>();
    private Map<Long, Poll> polls = new HashMap<>();
    private Map<Long, VoteOption> options = new HashMap<>();
    private Map<Long, Vote> votes = new HashMap<>();

    private int nextUserId = 1;
    private int nextPollId = 1;
    private int nextOptionId = 1;
    private int nextVoteId = 1;


    public User createUser(String name) {
        User u = new User(nextUserId++, name);
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


    public Vote castVote(User user, VoteOption option) {
        votes.values().removeIf(v -> v.getUser().getId().equals(user.getId()));
        Vote v = new Vote(nextVoteId++, user, option);
        votes.put(v.getId(), v);
        option.getVotes().add(v);
        return v;
    }
    public Collection<Vote> getVotes() { return votes.values(); }


    public void deletePoll(Long pollId) {
        polls.remove(pollId);
        votes.values().removeIf(v -> v.getOption() != null &&
                v.getOption().getId().equals(pollId));
    }
}