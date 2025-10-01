package Spring.jpa.repository;

import Spring.jpa.model.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepo extends CrudRepository<Poll, Long> {
}
