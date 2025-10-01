package Spring.jpa.repository;

import Spring.jpa.model.VoteOption;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VoteOptionRepo extends CrudRepository<VoteOption, UUID> {
}