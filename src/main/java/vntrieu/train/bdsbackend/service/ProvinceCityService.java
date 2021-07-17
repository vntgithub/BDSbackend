package vntrieu.train.bdsbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.ProvinceCity;
import vntrieu.train.bdsbackend.repository.ProvinceCityRepository;

@Service
public class ProvinceCityService {

  @Autowired
  private  ProvinceCityRepository repository;

  public List<ProvinceCity> getAll(){
    return repository.findAll();
  }

  public ProvinceCity add(ProvinceCity newProvinceCity) {
    return repository.save(newProvinceCity);
  }

  public ProvinceCity update(ProvinceCity p) {
    return repository.save(p);
  }

  public void delete(Integer id){
    repository.deleteById(id);
  }
}
