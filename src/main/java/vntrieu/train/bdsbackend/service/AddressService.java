package vntrieu.train.bdsbackend.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.repository.AddressRepository;

@AllArgsConstructor
@Service
public class AddressService {
  private final AddressRepository repository;

  public Address getByUserId(Long id){
    return repository.getByUserId(id);
  }

  public Address add(Address a) {
    return repository.save(a);
  }

  public Address update(Address a){
    if(repository.existsById(a.getId()))
      return repository.save(a);

    return null;
  }

  public String delete(Long id) {
    repository.deleteById(id);
    return "Deleted!";
  }
  public List<Address> searchByCity(Integer pId){
    return repository.searchByCity(pId);
  }

  public List<Address> searchByDistrict(Long districtId){
    return repository.searchByDistrict(districtId);
  }
  public List<Address> searchByWard(Long wardId){
    return repository.searchByWard(wardId);
  }

  public List<Address> searchByStreet(Long streetId){
    return repository.searchByStreet(streetId);
  }
}
