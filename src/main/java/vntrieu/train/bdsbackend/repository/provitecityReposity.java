package vntrieu.train.bdsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vntrieu.train.bdsbackend.model.ProviteCity;
@Repository
public interface provitecityReposity extends JpaRepository<ProviteCity, Integer> {

}
