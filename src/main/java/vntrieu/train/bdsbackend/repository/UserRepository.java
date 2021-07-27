package vntrieu.train.bdsbackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllBy(Pageable page);
}
