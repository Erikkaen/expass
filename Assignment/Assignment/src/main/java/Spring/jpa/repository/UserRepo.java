package Spring.jpa.repository;

import Spring.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends CrudRepository<User, Long> {
}