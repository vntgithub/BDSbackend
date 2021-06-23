package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.dto.StreetDTO;
import vntrieu.train.bdsbackend.model.Street;
import vntrieu.train.bdsbackend.repository.StreetRepository;

@AllArgsConstructor
@Service
public class StreetService {
  private final StreetRepository repository;

  public List<Street> filterByWardId(Long id){
    return repository.filter(id);
  }

  public Street add(Street s) {
    return repository.save(s);
  }

  public Street update(Street s) {
   return  repository.save(s);
  }

  public String delete (Long id) {
    repository.deleteById(id);
    return "Deleted!";
  }

}
