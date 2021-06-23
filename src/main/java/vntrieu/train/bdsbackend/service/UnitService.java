package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Unit;
import vntrieu.train.bdsbackend.repository.UnitRepository;

@Service
@AllArgsConstructor
public class UnitService {
  private UnitRepository repository;

  public List<Unit> getAll(){return repository.findAll();}

  public Unit add(Unit u){return repository.save(u);}

  public Unit update(Unit u){
    if(repository.existsById(u.getId()))
      return repository.save(u);
    return null;
  }

  public String delete(Integer id){
    repository.deleteById(id);
    return "Deleted!";
  }
}
