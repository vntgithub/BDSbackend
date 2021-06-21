package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.ProvinceCity;
import vntrieu.train.bdsbackend.repository.ProvinceCityRepository;

@Service
@AllArgsConstructor
public class ProvinceCityService {
  private final ProvinceCityRepository repository;

  public List<ProvinceCity> getAll(){
    System.out.println(repository.findAll());
    return repository.findAll();
  }

  public ProvinceCity add(ProvinceCity newProvinceCity) {
    return repository.save(newProvinceCity);
  }

  public ProvinceCity update(ProvinceCity p) {
    repository.findById(p.getId())
        .map(result -> {
          result.setName(p.getName());
          return repository.save(result);
        });
    return p;
  }

  public void delete(Integer id){
    repository.deleteById(id);
  }
}
