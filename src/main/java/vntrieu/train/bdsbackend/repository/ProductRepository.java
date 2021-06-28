package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product  p WHERE p.user.id=?1")
  public List<Product> getByUserId(Long id);

  @Query("SELECT p FROM Product p INNER JOIN Address a ON p.address.id = a .id " +
          "WHERE a.provinceCity.id=?1 " +
          "and a.district.id=?2 " +
          "and a.ward.id=?3 " +
          "and a.street.id=?4 " +
          "and  p.title like %?5%"


  )
  public List<Product> search(
          Integer provinceCityId,
          Long districtId,
          Long wardId,
          Long streetId,
          String searchString
  );

  @Query("SELECT p FROM Product p WHERE p.title like %?1%")
  public List<Product> searchTitle(String title);

}
