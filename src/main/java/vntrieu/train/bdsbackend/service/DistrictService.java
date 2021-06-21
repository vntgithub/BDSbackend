package vntrieu.train.bdsbackend.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.dto.DistrictDTO;
import vntrieu.train.bdsbackend.model.District;
import vntrieu.train.bdsbackend.repository.DistrictRepository;

@Service
@AllArgsConstructor
public class DistrictService {
  private final DistrictRepository repository;

  public List<District> getAll(){
    return repository.findAll();
  }

  public List<District>filter(Integer id) {
    return repository.filterByCityId(id);
  }

  public District add(District d) {
    return repository.save(d);
  }

  public District update(District d) {
    repository.findById(d.getId())
        .map(rs -> {
          rs.setName(d.getName());
          return repository.save(rs);
        });
    return d;
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
