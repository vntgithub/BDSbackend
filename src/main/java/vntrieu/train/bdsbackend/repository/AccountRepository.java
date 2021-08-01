package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("SELECT r.name FROM Account  a INNER JOIN Role r ON a.role.id=r.id WHERE a.username = ?1")
    String getRoleName(String userName);
}
