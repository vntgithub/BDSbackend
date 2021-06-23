package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.repository.ContactRepository;

@AllArgsConstructor
@Service
public class ContactService {
  private final ContactRepository repository;

  public Contact add(Contact c) {
    return repository.save(c);
  }

  public Contact update(Contact c){
    repository.findById(c.getId())
        .map(rs -> {
          rs = c;
          return repository.save(rs);
        });
    return c;
  }
  public String delete(Long id) {
    repository.deleteById(id);
    return "Deleted!";
  }
}
