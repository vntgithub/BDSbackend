package vntrieu.train.bdsbackend.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.District;
import vntrieu.train.bdsbackend.repository.DistrictRepository;

@Service
public class DistrictService {

  @Autowired
  private  DistrictRepository repository;

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
   return repository.save(d);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
