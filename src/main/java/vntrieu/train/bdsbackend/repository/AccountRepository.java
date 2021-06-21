package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
