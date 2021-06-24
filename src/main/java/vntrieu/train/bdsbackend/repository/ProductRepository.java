package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query("SELECT p FROM Product  p WHERE u_id=?1")
  public List<Product> getByUserId(Long id);
}
