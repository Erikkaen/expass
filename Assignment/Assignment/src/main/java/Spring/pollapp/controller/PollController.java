package main.java.Spring.pollapp.controller;

import main.java.Spring.pollapp.model.Poll;
import main.java.Spring.pollapp.model.User;
import main.java.Spring.pollapp.model.PollManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollManager manager;

    public PollController(PollManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public Poll createPoll(@RequestParam Long userId, @RequestParam String question) {
        User owner = manager.getUsers().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow();
        return manager.createPoll(question, owner);
    }

    @GetMapping
    public Collection<Poll> listPolls() {
        return manager.getPolls();
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id) {
        manager.deletePoll(id);
    }
}
