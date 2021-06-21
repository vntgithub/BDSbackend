package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vntrieu.train.bdsbackend.model.ProvinceCity;
@Repository
public interface ProvinceCityRepository extends JpaRepository<ProvinceCity, Integer> {

}
