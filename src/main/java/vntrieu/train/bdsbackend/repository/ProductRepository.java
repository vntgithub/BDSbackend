package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
