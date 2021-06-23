package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.repository.ContactRepository;

@AllArgsConstructor
@Service
public class ContactService {
  private final ContactRepository repository;

  public Contact update(Contact c){
    if(repository.existsById(c.getId()))
      return repository.save(c);
    return null;
  }
  public String delete(Long id) {
    repository.deleteById(id);
    return "Deleted!";
  }
}
