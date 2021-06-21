package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
