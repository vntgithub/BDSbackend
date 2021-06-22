package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.model.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {
  @Query("SELECT w FROM Ward w WHERE w.district.id =?1" )
  public List<Ward> filterByDistrictId(Long id);
}
