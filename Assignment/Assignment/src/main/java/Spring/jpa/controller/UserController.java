package Spring.jpa.controller;
import Spring.jpa.model.User;
import Spring.jpa.model.PollManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {
    private final PollManager manager;

    public UserController(PollManager manager) {
        this.manager = manager;
    }

    //RequestParam if I don't want json
    @PostMapping
    public User createUser(@RequestBody User user) {
        return manager.createUser(user.getName(), user.getEmail());
    }

    @GetMapping
    public Collection<User>  listUsers() {
        return manager.getUsers();
    }
}
