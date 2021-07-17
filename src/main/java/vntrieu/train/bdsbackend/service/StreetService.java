package vntrieu.train.bdsbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Street;
import vntrieu.train.bdsbackend.repository.StreetRepository;

@Service
public class StreetService {

  @Autowired
  private  StreetRepository repository;

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
