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

  public StreetDTO add(Street s) {
    return new StreetDTO(repository.save(s));
  }

  public StreetDTO update(Street s) {
    repository.findById(s.getId())
        .map(rs -> {
          rs.setName(s.getName());
          rs.setWard(s.getWard());
          return repository.save(rs);
        });
    return new StreetDTO(s);
  }

  public String delete (Long id) {
    repository.deleteById(id);
    return "Deleted!";
  }

}
