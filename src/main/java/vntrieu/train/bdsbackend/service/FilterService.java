package vntrieu.train.bdsbackend.service;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Filter;
import vntrieu.train.bdsbackend.repository.FilterRepository;

@Service
@AllArgsConstructor
public class FilterService {
  private final FilterRepository filterRepository;

  public Filter getByUserId(Long id){return filterRepository.getByUserId(id);}

  public Filter add(Filter filter){return filterRepository.save(filter);}

  public Filter update(Filter filter){
    if(filterRepository.existsById(filter.getId()))
      return filterRepository.save(filter);
    return null;
  }
}
