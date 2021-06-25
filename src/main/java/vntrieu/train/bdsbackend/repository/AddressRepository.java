package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
  @Query("SELECT a FROM Address a WHERE a.user.id=?1")
  public Address getByUserId(Long id);

  @Query("SELECT a FROM Address a WHERE a.provinceCity.id=?1")
  public List<Address> searchByCity(Integer pId);

  @Query("SELECT a FROM Address a WHERE a.district.id=?1")
  public List<Address> searchByDistrict(Long districtId);

  @Query("SELECT a FROM Address a WHERE a.ward.id=?1")
  public List<Address> searchByWard(Long wardId);

  @Query("SELECT a FROM Address a WHERE a.street.id=?1")
  public List<Address> searchByStreet(Long streetId);
}
