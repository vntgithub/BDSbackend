package vntrieu.train.bdsbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
  @Query("SELECT d FROM District d   WHERE d.provinceCity.id = ?1")
  public List<District> filterByCityId(Integer id);
}
