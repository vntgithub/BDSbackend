package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
  @Query("SELECT f FROM Filter f WHERE f.user.id=?1")
  public Filter getByUserId(Long id);
}
