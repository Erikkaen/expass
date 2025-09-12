package Spring.pollapp.controller;
import Spring.pollapp.model.Vote;
import Spring.pollapp.model.User;
import Spring.pollapp.model.PollManager;
import org.springframework.web.bind.annotation.*;
import Spring.pollapp.model.VoteOption;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/votes")
public class VoteController {
    private final PollManager manager;

    public VoteController(PollManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public Vote castVote(@RequestParam Long userId, @RequestParam Long optionId) {
        User user = manager.getUsers().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow();

        VoteOption option = manager.getPolls().stream()
                .flatMap(p -> p.getOptions().stream())
                .filter(o -> o.getId().equals(optionId))
                .findFirst()
                .orElseThrow();

        return manager.castVote(user, option);
    }

    @GetMapping
    public Collection<Vote> listVotes() {
        return manager.getVotes();
    }
}
