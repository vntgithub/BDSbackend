package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Ward;
import vntrieu.train.bdsbackend.repository.WardRepository;

@AllArgsConstructor
@Service
public class WardService {
  private final WardRepository repository;

  public List<Ward> filter(Long id) {
    return repository.filterByDistrictId(id);
  }

  public Ward add(Ward w) {
    return repository.save(w);
  }

  public Ward update(Ward w) {
    return repository.save(w);
  }

  public String delete(Long id){
    repository.deleteById(id);
    return "Deleted!";
  }
}
