package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
  @Query("SELECT a FROM Address a WHERE a.user.id=?1")
  public Address getByUserId(Long id);
}
