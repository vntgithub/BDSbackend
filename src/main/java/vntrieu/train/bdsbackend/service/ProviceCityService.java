package vntrieu.train.bdsbackend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.ProviteCity;
import vntrieu.train.bdsbackend.repository.provitecityReposity;

@Service
public class ProviceCityService {
  private final provitecityReposity reposity;

  @Autowired
  public ProviceCityService(provitecityReposity reposity) {
    this.reposity = reposity;
  }

  public List<ProviteCity> getAll(){
    System.out.println(reposity.findAll());
    return reposity.findAll();
  }

  public ProviteCity add(ProviteCity newProviteCity) {
    return reposity.save(newProviteCity);
  }
}
