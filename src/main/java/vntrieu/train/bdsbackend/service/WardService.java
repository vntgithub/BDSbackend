package vntrieu.train.bdsbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Ward;
import vntrieu.train.bdsbackend.repository.WardRepository;

@Service
public class WardService {
  @Autowired
  private  WardRepository repository;

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
