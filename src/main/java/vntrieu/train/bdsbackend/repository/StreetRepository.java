package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long> {
  @Query("SELECT st FROM Street st WHERE st.ward.id = ?1")
  public List<Street> filter(Long id);
}
