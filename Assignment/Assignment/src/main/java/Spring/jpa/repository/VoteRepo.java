package Spring.jpa.repository;

import Spring.jpa.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VoteRepo extends CrudRepository<Vote, UUID> {
}