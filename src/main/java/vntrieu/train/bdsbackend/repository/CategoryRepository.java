package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vntrieu.train.bdsbackend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
