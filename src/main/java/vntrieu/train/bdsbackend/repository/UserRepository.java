package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
