package Spring.jpa.controller;
import Spring.jpa.model.Vote;
import Spring.jpa.model.User;
import Spring.jpa.model.PollManager;
import org.springframework.web.bind.annotation.*;
import Spring.jpa.model.VoteOption;
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
