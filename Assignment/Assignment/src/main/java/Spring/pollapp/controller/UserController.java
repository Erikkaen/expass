package main.java.Spring.pollapp.controller;
import main.java.Spring.pollapp.model.Poll;
import main.java.Spring.pollapp.model.User;
import main.java.Spring.pollapp.model.PollManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    private final PollManager manager;

    public UserController(PollManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public User createUser(@RequestParam String name) {
        return manager.createUser(name);
    }

    @GetMapping
    public Collection<User>  listUsers() {
        return manager.getUsers();
    }
}
