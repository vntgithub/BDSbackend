package vntrieu.train.bdsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.repository.FilterRepository;

import java.util.List;

@Service
public class FilterService {

  @Autowired
  private  FilterRepository filterRepository;

  public List<Filter> getByUserId(Long id){return filterRepository.getByUserId(id);}

  public Filter add(Filter filter){return filterRepository.save(filter);}

  public Filter update(Filter filter){
    if(filterRepository.existsById(filter.getId()))
      return filterRepository.save(filter);
    return null;
  }
}
