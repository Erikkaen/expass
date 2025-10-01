package Spring.jpa;

import Spring.jpa.model.Poll;
import Spring.jpa.model.User;
import Spring.jpa.model.VoteOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.UnifiedJedis;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@RestController


public class PollAppApplication {
    public
    static void main(String[] args) {
        UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");
        System.out.println(jedis.ping()); // should print PONG

            User alice = new User("alice", "alice@online.com");
            User bob = new User("bob", "bob@bob.net");
            User eve = new User("eve", "eve@mail.org");
            Poll p1 = alice.createPoll("Pineapple on Pizza");
            VoteOption o1 = p1.addVoteOption("Mamma mia: Nooooo!");
            VoteOption o2 = p1.addVoteOption("Yes, yammy!");
            VoteOption o3 = p1.addVoteOption("I do not care");
            Poll p2 = bob.createPoll("Vim or Emacs");
            VoteOption o4 = p2.addVoteOption("vim");
            VoteOption o5 = p2.addVoteOption("emacs");
            alice.voteFor(o3);
            bob.voteFor(o1);
            eve.voteFor(o2);
            alice.voteFor(o4);


        jedis.close();
    }
}

/*
@SpringBootApplication
@RestController

public class PollAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PollAppApplication.class, args);
    }
}

*/

