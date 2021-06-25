package vntrieu.train.bdsbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vntrieu.train.bdsbackend.model.Account;
import vntrieu.train.bdsbackend.model.Address;
import vntrieu.train.bdsbackend.model.Contact;
import vntrieu.train.bdsbackend.model.User;
import vntrieu.train.bdsbackend.repository.AccountRepository;
import vntrieu.train.bdsbackend.repository.AddressRepository;
import vntrieu.train.bdsbackend.repository.ContactRepository;
import vntrieu.train.bdsbackend.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository repository;

  public User getById(Long id) {
    return repository.getById(id);
  }


  public User update(User u){
    repository.findById(u.getId())
        .map(rs -> {
          rs.setName(u.getName());
          rs.setAvt(u.getAvt());
          rs.setDateOfBirth(u.getDateOfBirth());
          rs.setGender(u.getGender());
          return repository.save(rs);
        });
    return repository.getById(u.getId());
  }

  public String delete(Long id){
    repository.deleteById(id);
    return "Deleted!";
  }

}
